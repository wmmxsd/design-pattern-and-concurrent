package com.wmm.concurrent.countdownlatch.childservice.impl;

import com.wmm.concurrent.countdownlatch.childservice.BaseHealthChecker;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/11/19 16:38
 */
public class CacheHealthChecker extends BaseHealthChecker {
    /**
     * Get latch object in constructor so that after completing the task, thread can countDown() the latch
     *
     * @param latch       计时器
     */
    public CacheHealthChecker(CountDownLatch latch) {
        super("CacheHealthChecker", latch);
    }

    @Override
    public void startService() {
        System.out.println(getCurrentThreadName() + " —— starting " + this.getServiceName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getCurrentThreadName() + " —— " +  this.getServiceName() + " is started");
    }
}
