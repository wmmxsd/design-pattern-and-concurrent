package com.wmm.concurrent.semaphore.bounded;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/23 11:38
 */
public class MyThread  extends Thread{
    private BoundedSemaphore boundedSemaphore;

    public MyThread(BoundedSemaphore boundedSemaphore) {
        this.boundedSemaphore = boundedSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                boundedSemaphore.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                boundedSemaphore.release();
                try {
                    Thread.sleep(4000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
