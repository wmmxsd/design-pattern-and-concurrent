package com.wmm.concurrent.huangryandfair.reentrance_lockout;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/22 17:46
 */
public class App {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), r -> new Thread(r, "test_"+ integer.incrementAndGet()) );

        Runnable runnable = new Runnable() {
            Lock lock = new Lock();
            @Override
            public void run() {
                try {
                    lock.lock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        };

        for (int count = 0; count < 100; count++) {
            executorService.submit(runnable);
        }
    }
}
