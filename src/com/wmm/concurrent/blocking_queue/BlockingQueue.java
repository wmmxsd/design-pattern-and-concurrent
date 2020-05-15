package com.wmm.concurrent.blocking_queue;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangmingming160328
 * @Description 阻塞队列
 * @date @2019/10/25 18:55
 */
public class BlockingQueue {
    private final List<Object> queue = new LinkedList<>();
    private int limit;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    /**
     * 入队
     * @param object
     * @throws InterruptedException
     */
    public synchronized void enqueue(Object object) throws InterruptedException{
        if (queue.size() == 0) {
            notifyAll();
        }

        if (limit == queue.size()) {
            wait();
        }

        queue.add(object);
        System.out.println(Thread.currentThread().getName() + "：入队， size ：" + queue.size());
    }

    synchronized void dequene() throws InterruptedException {
        if (queue.size() == 0) {
            wait();
        }

        if (limit == queue.size()) {
            notifyAll();
        }

        queue.remove(0);
        System.out.println(Thread.currentThread().getName() + "：出队， size ：" + queue.size());
    }
}
