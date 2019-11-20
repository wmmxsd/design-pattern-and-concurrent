package com.wmm.concurrent.semaphore.counting;

/**
 * @author wangmingming160328
 * @Description 可计数的信号量
 * @date @2019/10/24 17:59
 */
public class CountingSemaphore {
    private int signal = 0;

    public synchronized void lock() {
        notify();
        this.signal++;
        System.out.println(Thread.currentThread().getName() + "—— lock()：signal = " + signal);

    }

    public synchronized void release() {
        if (this.signal == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.signal--;
        System.out.println(Thread.currentThread().getName() + "—— release()：signal = " + signal);
    }
}
