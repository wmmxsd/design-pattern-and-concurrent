package com.wmm.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import static java.util.concurrent.Executors.*;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/8/9 14:28
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService0 = newSingleThreadExecutor();
        //new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        ExecutorService executorService1 = newCachedThreadPool();
        //new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        ExecutorService executorService2 = newFixedThreadPool(2);
        //new `ThreadPoolExecutor`(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        ExecutorService executorService3 = newScheduledThreadPool(2);
        //new ThreadPoolExecutor(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS, new ScheduledThreadPoolExecutor.DelayedWorkQueue());
        ExecutorService executorService4 = newWorkStealingPool();
        /*executorService.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("hello world !");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });*/


        System.out.println(" ===> main Thread execute here ! ");
    }
}
