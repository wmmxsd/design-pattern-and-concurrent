package com.wmm.concurrent.semaphore.simple;

/**
 * @author wangmingming160328
 * @Description 简单的信号实现（Semaphore（信号量） 是一个线程同步结构，用于在线程间传递信号，以避免出现信号丢失（译者注：下文会具体介绍），或者像锁一样用于保护一个关键区域）
 * @date @2019/7/22 19:15
 */
public class Semaphore {
    private boolean signal;

    {
        signal = false;
    }


    synchronized void take() {
        this.signal = true;
        System.out.println(Thread.currentThread().getName() + "的take方法中的signal为：true");
        //this.notify()代表唤醒当前线程，RecevingThread和SendingThread的实例，与Semaphore实例无关
        this.notify();
    }

    public synchronized void release() {
        while (!this.signal) {
            try {
                System.out.println(Thread.currentThread().getName() + "的release方法中的signal为：false");
                //this.wait()代表当前线程处于等待状态，RecevingThread和SendingThread的实例，与Semaphore实例无关
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.signal = false;
    }
}
