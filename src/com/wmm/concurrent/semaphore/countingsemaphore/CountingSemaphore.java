package com.wmm.concurrent.semaphore.countingsemaphore;

/**
 * 一个 <i>countingSemaphore</i> 是一个可计数的信号量。
 * <ul>
 * <li><p>可带上信号数量上限，当达到上限则wait</p></li>
 * <li><p>当信号量的数量上限是1时，Semaphore可以被当做锁来使用。通过take和release方法来保护关键区域。</p></li>
 * </ul>
 *
 * @author wangmingming160328
 * @date @2019/7/23 10:35
 */
public class CountingSemaphore {
    private int signals = 0;
    private int bound;

    public CountingSemaphore(int bound) {
        this.bound = bound;
    }

    /**
     * 生成信号
     *
     * @throws InterruptedException
     */
    public synchronized void take() throws InterruptedException {
        while (this.signals == bound) {
            wait();
        }
        this.signals++;
        this.notify();
        System.out.println(Thread.currentThread().getName() + "—— take()：signals = " + signals);
    }

    /**
     * 释放信号
     *
     * @throws InterruptedException
     */
    public synchronized void release() {
        while (this.signals == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.signals--;
        System.out.println(Thread.currentThread().getName() + "—— release()：signals = " + signals);
    }

    public int getSignals() {
        return signals;
    }
}
