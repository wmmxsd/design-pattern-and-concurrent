package com.wmm.concurrent.keywordaboutlock;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Start implements Runnable {
    private static int count = 0;

    @Override
    public void run() {
        synchronized (this) {
            for(int i=0; i<100000; i++){
                count++;
//                System.out.println(Thread.currentThread().getName() + " count:" + count);
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Start st = new Start();
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);
        t1.start();
        t2.start();
        t1.join();
//        t2.join();
        System.out.println(count);
        System.out.println("run over");
    }
}
