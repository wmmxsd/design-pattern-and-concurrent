package com.wmm.concurrent;

/**
 * @author wangmingming160328
 * @Description Thread类实现线程
 * @date @2019/7/17 17:19
 */
public class ThreadDemo extends Thread{
    @Override
    public void run() {
        System.out.println("ThreadDemo running");
    }

    private static void startThread() {
        //第一种方式：继承Thread类
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();

        //第二种方式，new一个Thread的匿名子类的实例
        Thread thread = new Thread(() -> System.out.println("ThreadDemo running1"));
        thread.start();
    }

    private static void startTenThread() {
        System.out.println(Thread.currentThread().getName());
        for (int count = 0; count <100; count++) {
            new Thread("" + count) {
                @Override
                public void run() {
                    System.out.println("Thread: " + getName() + " is running");

                }
            }.start();
        }
    }

    public static void main(String[] args) {
        startThread();

//        startTenThread();
    }

}
