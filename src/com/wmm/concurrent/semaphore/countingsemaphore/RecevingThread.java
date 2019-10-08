package com.wmm.concurrent.semaphore.countingsemaphore;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/23 10:39
 */
public class RecevingThread extends Thread {
    private CountingSemaphore countingSemaphore;

    public RecevingThread(CountingSemaphore countingSemaphore) {
        super("recevingThread");
        this.countingSemaphore = countingSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            this.countingSemaphore.release();
        }
//            System.out.println(Thread.currentThread().getName() + " ——  RecevingThread：signals = " + this.countingSemaphore.getSignals());
    }
}
