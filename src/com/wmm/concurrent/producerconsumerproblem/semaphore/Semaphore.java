package com.wmm.concurrent.producerconsumerproblem.semaphore;

/**
 * @author wangmingming160328
 * @Description 用信号量解决生产者消费者问题
 * @date @2020/5/15 9:55
 */
public class Semaphore {
    protected static Integer count = 0;
    protected static final java.util.concurrent.Semaphore NOT_FULL = new java.util.concurrent.Semaphore(10);
    protected static final java.util.concurrent.Semaphore NOT_EMPTY = new java.util.concurrent.Semaphore(0);
    protected static final java.util.concurrent.Semaphore MUTEX = new java.util.concurrent.Semaphore(1);
}

