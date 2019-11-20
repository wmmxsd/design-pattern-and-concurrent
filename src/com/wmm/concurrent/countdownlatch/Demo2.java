package com.wmm.concurrent.countdownlatch;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 创建一个倒计时值为1的CountDownLatch对象，通过对线程池中的每个线程执行await()方法使其阻塞，然后在主线程中执行countDown()方法，让被阻塞的线程们实现最大的并行性。
 * @author wangmingming160328
 * @Description
 * @date @2019/11/19 18:22
 */
public class Demo2 {
    /**
     * 模拟高并发情况代码
     */
    private static void concurrenceTest() {
        final AtomicInteger atomicInteger = new AtomicInteger(0);

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        AtomicInteger integer = new AtomicInteger(0);
        ExecutorService executorService = new ThreadPoolExecutor(4, 4, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), r -> new Thread(r, "test_" + integer.getAndIncrement()));

        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println("当前线程：" + Thread.currentThread().getName());
                try {
                  countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int j = 0; j < 1000000; j++) {
                    atomicInteger.incrementAndGet();
                }
            });
        }


        System.out.println("主线程");
        //注释countDown()方法，线程池中的线程都会阻塞，并且不能被唤醒
        countDownLatch.countDown();
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                System.out.println(atomicInteger);
                System.out.println("耗时：" + (System.currentTimeMillis() - beginTime) + "ms");
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        concurrenceTest();
    }
}
