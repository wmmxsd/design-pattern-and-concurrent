package com.wmm.concurrent.aqs.aql_demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 互斥锁
 * @author wangmingming160328
 * @Description
 * @date @2019/10/22 19:36
 */
public class ExclusiveApp {
    private static int a = 0;
    private static MutexLock mutex = new MutexLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 100000; i++) {
                increaseWithNoLock();
            }
        };

        Runnable runnable1 = () -> {
            for (int i = 0; i < 100000; i++) {
                increaseWithLock();
            }
        };

        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService executorService = new ThreadPoolExecutor(8, 16, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), r -> new Thread(r, "test_" + atomicInteger.getAndDecrement()));

        for (int count = 0; count < 30; count++) {
//            executorService.submit(runnable);
            executorService.submit(runnable1);
        }

        Thread.sleep(2000L);
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                System.out.println(a);
                break;
            }
        }
    }

    private static void increaseWithNoLock() {
        a++;
    }

    private static void increaseWithLock() {
        mutex.lock();
        a++;
        mutex.unlock();
    }
}
