package com.wmm.concurrent.countdownlatch.childservice;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author wangmingming160328
 * @Description Runnable业务抽象类
 * @date @2019/11/19 16:31
 */
public abstract class BaseHealthChecker implements Callable<Boolean> {

    private CountDownLatch latch;
    private String serviceName;

    /**
     * Get latch object in constructor so that after completing the task, thread can countDown() the latch
     * @param serviceName 服务名
     * @param latch 计时器
     */
    public BaseHealthChecker(String serviceName, CountDownLatch latch) {
        super();
        this.latch = latch;
        this.serviceName = serviceName;
    }

    @Override
    public Boolean call() {
        boolean result = false;
        try {
            startService();
            result = true;
        } catch (Throwable t) {
            t.printStackTrace(System.err);
        } finally {
            if (latch != null) {
                latch.countDown();
            }
        }
        return result;
    }

    protected String getServiceName() {
        return serviceName;
    }

    protected String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    /**
     * This methos needs to be implemented by all specific service checker
     */
    public abstract void startService();
}
