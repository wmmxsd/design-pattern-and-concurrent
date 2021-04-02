package com.wmm.concurrent.reentrantlock;

/**
 * @author wangmingming160328
 * @Description SynchronizedDemo
 * @date @2020/5/24 22:10
 */
public class SynchronizedDemo {
    int i = 0;
    public synchronized void test() {
        i++;
        System.out.println(Thread.currentThread().getName() + ":" + i);
    }
}
