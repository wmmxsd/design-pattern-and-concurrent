package com.wmm.concurrent.fairlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/11/20 15:00
 */
public class App {
    public static void main(String[] args) {
        TicketLock lock = new TicketLock();

        AtomicInteger integer = new AtomicInteger(0);
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), r -> new Thread(r, "ticketlock_" + integer.getAndIncrement()));



        for (int index = 0; index < 2; index++) {
            executorService.execute(() -> {
                lock.lock();
                lock.unlock();
            });
        }


        executorService.shutdown();

        while (!executorService.isTerminated()) {
            //自旋
        }

        System.out.println("the end");
    }
}
