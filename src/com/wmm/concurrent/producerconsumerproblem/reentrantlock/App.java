package com.wmm.concurrent.producerconsumerproblem.reentrantlock;

import com.wmm.concurrent.producerconsumerproblem.reentrantlock.Consumer;
import com.wmm.concurrent.producerconsumerproblem.reentrantlock.Producer;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangmingming160328
 * @Description
 * @date @2020/5/15 11:51
 */
public class App {
    public static void main(String[] args) {
        AtomicInteger producerIndex = new AtomicInteger(0);
        AtomicInteger consumerIndex = new AtomicInteger(0);
        ThreadFactory producerThreadFactory = r -> new Thread(r, "produce——" + producerIndex.getAndIncrement());
        ThreadFactory consumerThreadFactory = r -> new Thread(r, "consumer——" + consumerIndex.getAndIncrement());
        ExecutorService producerService = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new SynchronousQueue<>(), producerThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        ExecutorService consumerService = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new SynchronousQueue<>(), consumerThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        Runnable producerRunnable = () -> {
            while (true) {
                producer.produce();
            }
        };
        Runnable consumerRunnable = () -> {
            while (true) {
                consumer.consume();
            }
        };
        for (int index = 0; index < 10; index++) {
            producerService.execute(producerRunnable);
        }
        for (int index = 0; index < 10; index++) {
            consumerService.execute(consumerRunnable);
        }

        producerService.shutdown();
        consumerService.shutdown();
        while (true) {
            if (producerService.isTerminated() && consumerService.isTerminated()) {
                break;
            }

        }
    }
}
