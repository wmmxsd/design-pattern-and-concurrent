package com.wmm.concurrent.memorymodel;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/18 10:39
 */
public class App {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread0 = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        thread0.start();
        thread1.start();
    }
}
