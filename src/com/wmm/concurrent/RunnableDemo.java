package com.wmm.concurrent;

/**
 * @author wangmingming160328
 * @Description Runnable接口实现线程
 * @date @2019/7/17 17:22
 */
public class RunnableDemo implements Runnable{

    @Override
    public void run() {
        System.out.println("RunnableDemo running");
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("RunnableDemo running");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
