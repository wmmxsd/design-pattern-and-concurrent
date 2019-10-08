package com.wmm.concurrent.huangryandfair.nested_monitor_lockout;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/18 16:58
 */
public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            Lock lock = new Lock();
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println(1);
                    lock.unlock();
                    System.out.println(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        Thread thread0 = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        thread0.start();
        thread1.start();
    }
}
