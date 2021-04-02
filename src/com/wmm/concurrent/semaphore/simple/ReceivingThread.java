package com.wmm.concurrent.semaphore.simple;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/22 19:15
 */
public class ReceivingThread extends Thread {

    private final Semaphore semaphore;

    public ReceivingThread(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            this.semaphore.take();
            try {
                Thread.sleep(4000L);
                this.semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
