package com.wmm.concurrent.spinlock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wangmingming160328
 * @Description 可重入的自旋锁
 * @date @2019/11/20 14:04
 */
public class ReentrantSpinLock {
    private AtomicReference<Thread> cas = new AtomicReference<>();
    /**
     * 重入次数
     */
    private int count = 0;

    public void lock() {
        Thread thread = Thread.currentThread();
        AtomicInteger integer = new AtomicInteger(0);

        //重入判断
        if (thread == cas.get()){
            System.out.println(thread.getName() + "第" + ++count + "次重入");
            return;
        }

        while (!cas.compareAndSet(null, thread)) {
            System.out.println(thread.getName() + "第" + integer.incrementAndGet()+"次尝试获取锁失败");
        }
        System.out.println(thread.getName() + "尝试" + integer.incrementAndGet()+ "次后获取到锁");
        integer.set(0);
    }

    public void unlock() {
        Thread thread = Thread.currentThread();

        if (thread == cas.get()){
            // 如果大于0，表示当前线程多次获取了该锁，释放锁通过count减一来模拟
            if (count > 0) {
                System.out.println(thread.getName() + "的重入值为" + --count);
                ;
            // 如果count==0，可以将锁释放，这样就能保证获取锁的次数与释放锁的次数是一致的了。
            }else {
                cas.compareAndSet(thread, null);
                System.out.println(Thread.currentThread().getName() + "释放锁");
            }
        }
    }
}
