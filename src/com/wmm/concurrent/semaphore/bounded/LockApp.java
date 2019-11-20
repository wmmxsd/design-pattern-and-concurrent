package com.wmm.concurrent.semaphore.bounded;

/**
 * @author wangmingming160328
 * @Description 上限为1的信号量Demo
 * @date @2019/7/23 11:34
 */
public class LockApp {
    public static void main(String[] args) {
        BoundedSemaphore boundedSemaphore = new BoundedSemaphore(4);

        for (int count = 0; count < 100; count++) {
            new MyThread(boundedSemaphore).start();
        }
    }
}
