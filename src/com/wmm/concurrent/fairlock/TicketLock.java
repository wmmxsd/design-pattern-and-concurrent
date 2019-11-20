package com.wmm.concurrent.fairlock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/11/20 14:52
 */
public class TicketLock {
    /**
     * 服务号（释放锁）
     */
    private AtomicInteger serviceNum = new AtomicInteger();
    /**
     * 排队号（请求锁）
     */
    private AtomicInteger ticketNum = new AtomicInteger();

    /**
     *每个线程的排队号
     */
    private ThreadLocal<Integer> ticketNumHolder = new ThreadLocal<Integer>();

    public void lock() {
        int currentTicketNum = ticketNum.incrementAndGet();
        ticketNumHolder.set(currentTicketNum);
        System.out.println(Thread.currentThread().getName() + "的当前排队号：" + currentTicketNum + "；当前服务号：" + serviceNum.get());
        while (currentTicketNum != serviceNum.get()) {
            //当前排队号和服务号不匹配
//            System.out.println("当前排队号和服务号不匹配");
        }
    }

    public void unlock() {
        Integer currentTickNum = ticketNumHolder.get();
        serviceNum.compareAndSet(currentTickNum, currentTickNum + 1);
        System.out.println(Thread.currentThread().getName() + "的当前服务号：" + serviceNum.get()+ "；当前排队号：" + ticketNum.get());
    }
}
