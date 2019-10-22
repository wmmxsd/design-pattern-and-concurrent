package com.wmm.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/21 11:51
 */
public class FixPoolDemo {
    private static Runnable getThread(final int i) {
        return () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        };
    }

    public static void main(String[] args) {
        ExecutorService fixPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 19; i++) {
            fixPool.execute(getThread(i));
        }
        fixPool.shutdown();
    }
}
