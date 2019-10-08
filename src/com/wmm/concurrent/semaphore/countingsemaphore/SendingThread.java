package com.wmm.concurrent.semaphore.countingsemaphore;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/23 10:40
 */
public class SendingThread  extends Thread{
    private CountingSemaphore countingSemaphore;

    public SendingThread(CountingSemaphore countingSemaphore) {
        super("sendingThread");
        this.countingSemaphore = countingSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.countingSemaphore.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(Thread.currentThread().getName() + " ——  SendingThread：signals = " + this.countingSemaphore.getSignals());
        }
    }
}
