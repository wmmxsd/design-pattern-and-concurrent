package com.wmm.concurrent.semaphore.bounded;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/23 10:39
 */
public class RecevingThread extends Thread {
    private BoundedSemaphore boundedSemaphore;

    public RecevingThread(BoundedSemaphore boundedSemaphore) {
        super("recevingThread");
        this.boundedSemaphore = boundedSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            this.boundedSemaphore.release();
            try {
                Thread.sleep(4000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//            System.out.println(Thread.currentThread().getName() + " ——  RecevingThread：signals = " + this.boundedSemaphore.getSignals());
    }
}
