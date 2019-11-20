package com.wmm.concurrent.huangryandfair.nested_monitor_lockout;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/18 16:58
 */
public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            Lock lock = new Lock();

            @Override
            public void run() {
                try {
                    lock.lock();
//                    System.out.println(1);
                    lock.unlock();
//                    System.out.println(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        ThreadFactory threadFactory = r -> new Thread(r, "test_" + new Random().nextInt(20));
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int count = 0; count < 10; count++) {
            executorService.submit(runnable);
        }

        executorService.shutdown();
    }
}
