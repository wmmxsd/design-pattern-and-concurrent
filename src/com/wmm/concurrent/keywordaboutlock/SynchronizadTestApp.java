package com.wmm.concurrent.keywordaboutlock;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangmingming160328
 * @Description
 * @date @2020/5/13 17:27
 */
public class SynchronizadTestApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主进程名：" + Thread.currentThread().getName());
        AtomicInteger index = new AtomicInteger();
        ThreadFactory threadFactory = r -> new Thread(new ThreadGroup("TEST"), r, "demo-pool-" + index.getAndIncrement());
        ExecutorService executorService = new ThreadPoolExecutor(2, 20, 0L, TimeUnit.SECONDS, new SynchronousQueue<>(), threadFactory, new ThreadPoolExecutor.AbortPolicy());

        synchronizedTest synchronizedTest = new synchronizedTest();
        Runnable runnable = () -> {
            for (int i = 0; i < 100000000; i++) {
//                synchronizedTest.incr();
//                synchronizedTest.incrWithSyncThis();
                synchronizedTest.incrWithSyncClass();
            }

        };

        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);


        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                System.out.println(synchronizedTest.i);
                break;
            }
        }

    }
}
