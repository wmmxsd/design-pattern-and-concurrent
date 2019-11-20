package com.wmm.concurrent.semaphore.counting;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/25 15:24
 */
public class App {
    private final CountingSemaphore countingSemaphore = new CountingSemaphore();

    private void execute() {
        ExecutorService executorService = new ThreadPoolExecutor(30, 30, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
            private final AtomicInteger mThreadNum = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            }
        });

        Runnable runnable = () -> {
            while (true) {
                try {
                    countingSemaphore.lock();
                }  catch (Exception e){
                    e.printStackTrace();
                }finally {
                    countingSemaphore.release();
                    try {
                        Thread.sleep(400L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        for (int count = 0; count < 100; count++) {
            executorService.execute(runnable);
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.execute();
    }
}
