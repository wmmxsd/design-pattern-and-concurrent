package com.wmm.concurrent.reentrantlock;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangmingming160328
 * @Description
 * @date @2020/5/24 22:20
 */
public class SynchronizedDemoApp {
    public static void main(String[] args) {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        AtomicInteger threadIndex = new AtomicInteger(0);
        ThreadFactory factory = r -> new Thread(r,"test-" + threadIndex.getAndIncrement());
        ExecutorService executorService = new ThreadPoolExecutor(5,
                5,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                factory,
                new ThreadPoolExecutor.AbortPolicy());
        Runnable runnable = () -> {
            synchronizedDemo.test();
        };
        for (int index = 0; index < 5000000; index++) {
            executorService.execute(runnable);
        }

        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                break;
            }
        }
    }
}
