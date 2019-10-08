package com.wmm.concurrent.threadpool;

import java.util.concurrent.*;

/**
 * @author wangmingming160328
 * @Description 自定义线程池
 * @date @2019/8/9 14:44
 */
public class CustomizedThreadPool {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(new ThreadGroup("TEST"), r, "demo-pool-%d");
            }
        };
        ExecutorService threadPool =
                new ThreadPoolExecutor(1, 2, 0L, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>(), threadFactory,  new ThreadPoolExecutor.AbortPolicy());
        threadPool.submit(new Callable<Object>() {
            @Override
            public String call() throws Exception {
                while (true) {
                    System.out.println("looping.");
                    Thread.sleep(2000);
                }
            }
        });
        threadPool.submit(new Runnable() {
            @Override
            public void run()  {
                while (true) {
                    System.out.println("loop1111ing.");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
