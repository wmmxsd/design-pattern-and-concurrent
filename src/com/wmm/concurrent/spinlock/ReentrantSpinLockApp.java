package com.wmm.concurrent.spinlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wangmingming160328
 * @Description 自选锁
 * @date @2019/11/20 11:24
 */
public class ReentrantSpinLockApp {
    private static ReentrantSpinLock lock = new ReentrantSpinLock();

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger integer = new AtomicInteger(0);
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), r -> new Thread(r, "spinlock_" + integer.getAndIncrement()));

        //可重入性测试
       for (int index = 0; index < 1; index++) {
            executorService.execute(new TaskB());
        }


        executorService.shutdown();

        while (!executorService.isTerminated()) {
            //自旋
        }

        System.out.println("the end");
    }


    /**
     * 不可重入锁
     */
    private static class TaskB implements Runnable {
        @Override
        public void run() {
            lock.lock();
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "正在执行TaskB");
            lock.unlock();
            lock.unlock();
        }
    }
}
