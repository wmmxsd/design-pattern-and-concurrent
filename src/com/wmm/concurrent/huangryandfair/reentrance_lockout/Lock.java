package com.wmm.concurrent.huangryandfair.reentrance_lockout;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/22 17:45
 */
public class Lock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "：isLocked：" + isLocked);
        while (isLocked) {
            System.out.println(Thread.currentThread().getName() + "等待，若2个线程都为等待且没有被唤醒，则死锁");
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        System.out.println(Thread.currentThread().getName() + "唤醒");
        notify();
    }
}
