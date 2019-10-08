package com.wmm.concurrent.huangryandfair;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/18 16:20
 */
public class QueueObject {

    private boolean isNotified = false;

    public synchronized void doWait() throws InterruptedException {

        while(!isNotified){
            this.wait();
        }

        this.isNotified = false;

    }

    public synchronized void doNotify() {
        this.isNotified = true;
        this.notify();
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

}

