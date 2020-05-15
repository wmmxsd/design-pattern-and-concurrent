package com.wmm.concurrent.producerconsumerproblem.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangmingming160328
 * @Description 锁
 * @date @2020/5/15 12:36
 */
public class Lock {
    /**
     * 未消费的产品数量
     */
    protected static int count = 0;
    protected static final ReentrantLock LOCK = new ReentrantLock();
    /**
     * 缓冲区非满
     */
    protected static Condition NOT_FULL = LOCK.newCondition();
    /**
     * 缓冲区非空
     */
    protected static Condition NOT_EMPTY = LOCK.newCondition();
}
