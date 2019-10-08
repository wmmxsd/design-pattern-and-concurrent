package com.wmm.concurrent.semaphore.countingsemaphore;

/**
 * @author wangmingming160328
 * @Description 上限为1的信号量Demo
 * @date @2019/7/23 11:34
 */
public class LockApp {
    public static void main(String[] args) {
        CountingSemaphore countingSemaphore = new CountingSemaphore(1);
        MyThread myThread_0 = new MyThread(countingSemaphore);
        MyThread myThread_1 = new MyThread(countingSemaphore);
        myThread_0.start();
        myThread_1.start();
    }
}
