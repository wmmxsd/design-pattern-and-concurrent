package com.wmm.concurrent.spinlock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wangmingming160328
 * @Description 自选锁
 * @date @2019/11/20 11:24
 */
public class SpinLock {
    private AtomicReference<Thread> cas = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        AtomicInteger integer = new AtomicInteger(0);
        while (!cas.compareAndSet(null, thread)) {
            System.out.println(thread.getName() + "第" + integer.incrementAndGet()+"次尝试获取锁失败");
        }
        System.out.println(thread.getName() + "尝试" + integer.incrementAndGet()+ "次后获取到锁");
        integer.set(0);
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        cas.compareAndSet(thread, null);
    }
}
