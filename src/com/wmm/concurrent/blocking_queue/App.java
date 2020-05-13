package com.wmm.concurrent.blocking_queue;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/23 14:57
 */
public class App {
    private final BlockingQueue blockingQueue = new BlockingQueue(5);

    private void execute() {
        ExecutorService executorService = new ThreadPoolExecutor(300, 300, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
            private final AtomicInteger mThreadNum = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            }
        });

        Runnable runnable = () -> {
            while (true) {
                try {
                    blockingQueue.enqueue(new Object());
                }  catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try {
                        blockingQueue.dequene();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(4000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        for (int count = 0; count < 300; count++) {
            executorService.execute(runnable);
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.execute();
    }
}
