package com.wmm.concurrent.spinlock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author wangmingming160328
 * @Description 多处理器系统上，每个进程/线程占用的处理器都在读写同一个变量serviceNum ，每次读写操作都必须在多个处理器缓存之间进行缓存同步，这会导致繁重的系统总线和内存的流量，大大降低系统整体的性能
 *                      CLH锁是一种基于链表的可扩展、高性能、公平的自旋锁，申请线程只在本地变量上自旋，它不断轮询前驱的状态，如果发现前驱释放了锁就结束自旋，获得锁
 * @date @2019/11/20 15:31
 */
public class CLHLock {
    /**
     * 尾部节点,只用一个节点即可
     */
    private volatile CLHNode tail;
    private static final ThreadLocal<CLHNode> LOCAL = new ThreadLocal<>();
    private static final AtomicReferenceFieldUpdater<CLHLock, CLHNode> UPDATER = AtomicReferenceFieldUpdater.newUpdater(CLHLock.class, CLHNode.class, "tail");
    /**
     * 定义一个节点，默认的lock状态为true
     */
    public static class CLHNode{
        private volatile boolean isLock = true;
    }

    public void lock() {
        //将新建节点与当前线程绑定
        CLHNode node = new CLHNode();
        LOCAL.set(node);

        //新建节点设置为尾部节点，并返回原节点
        CLHNode preNode = UPDATER.getAndSet(this, node);

        if (preNode != null) {
            //前驱节点不为null表示当锁被其他线程占用，通过不断轮询判断前驱节点的锁标志位等待前驱节点释放锁
            while (preNode.isLock){
                //doNothing
            }
            LOCAL.set(node);
        }
        // 如果不存在前驱节点，表示该锁没有被其他线程占用，则当前线程获得锁
    }

    public void unlock() {
        CLHNode node = LOCAL.get();

        // 如果tail节点等于node，则将tail节点更新为null，同时将node的lock状态职位false，表示当前线程释放了锁
        if (!UPDATER.compareAndSet(this, node, null)) {
            node.isLock = false;
        }
        node = null;
    }
}
