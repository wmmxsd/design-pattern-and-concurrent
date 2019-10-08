package com.wmm.concurrent.semaphore.countingsemaphore;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/23 11:38
 */
public class MyThread  extends Thread{
    private CountingSemaphore countingSemaphore;

    public MyThread(CountingSemaphore countingSemaphore) {
        this.countingSemaphore = countingSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                countingSemaphore.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countingSemaphore.release();
            }
        }
    }
}
