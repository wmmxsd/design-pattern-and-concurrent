package com.wmm.concurrent.sync.staticdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangmingming160328
 * @Description
 * @date @2020/1/3 20:41
 */
public class App {
    public static volatile List<Integer> integerList = new ArrayList<>();

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        ThreadFactory threadFactory = r -> new Thread(new ThreadGroup("TEST"), r, "demo-pool-" + integer.getAndIncrement());
        ExecutorService threadPool = new ThreadPoolExecutor(4, 10, 0L, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>(), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        AtomicInteger i = new AtomicInteger(0);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (integerList){
//                    System.out.println(Thread.currentThread().getName());
                    integerList.add(i.getAndIncrement());
                }
            }
        };
        for (int j = 0; j < 1000000; j++) {
            threadPool.execute(runnable);
        }


        threadPool.shutdown();

        while (true) {
            if (threadPool.isTerminated()) {
                System.out.println(integerList);
                break;
            }
        }
    }
}
