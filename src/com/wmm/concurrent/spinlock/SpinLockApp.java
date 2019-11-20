package com.wmm.concurrent.spinlock;

import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangmingming160328
 * @Description 自选锁主程序
 * @date @2019/11/20 11:27
 */
public class SpinLockApp {
    private static SpinLock lock = new SpinLock();

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger integer = new AtomicInteger(0);
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), r -> new Thread(r, "spinlock_" + integer.getAndIncrement()));
        //自旋锁测试
        for (int index = 0; index < 20; index++) {
            executorService.execute(new SpinLockApp.TaskA());
        }

        //可重入性测试
    /*   for (int index = 0; index < 4; index++) {
            executorService.execute(new SpinLockApp. TaskB());
        }*/


        executorService.shutdown();

        while (!executorService.isTerminated()) {
            //自旋
        }

        System.out.println("the end");
    }

    private static class TaskA implements Runnable {
        @Override
        public void run() {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "正在执行TaskA");
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放锁");
        }
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
            System.out.println(Thread.currentThread().getName() + "释放锁");
        }
    }
}
