package com.wmm.concurrent.atom;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/21 17:18
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        atomicInteger.getAndIncrement();
        System.out.println("getAndIncrement() :" + atomicInteger.get());

        atomicInteger.getAndDecrement();
        System.out.println("getAndDecrement() :" + atomicInteger.get());

        atomicInteger.addAndGet(2);
        System.out.println("addAndGet() :" + atomicInteger.get());

        atomicInteger.compareAndSet(2, 3);
        System.out.println("compareAndSet() :" + atomicInteger.get());


    }
}
