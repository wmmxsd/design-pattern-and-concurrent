package com.wmm.concurrent.semaphore.bounded;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/23 10:40
 */
public class SendingThread  extends Thread{
    private BoundedSemaphore boundedSemaphore;

    public SendingThread(BoundedSemaphore boundedSemaphore) {
        super("sendingThread");
        this.boundedSemaphore = boundedSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.boundedSemaphore.take();
                Thread.sleep(4000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(Thread.currentThread().getName() + " ——  SendingThread：signals = " + this.boundedSemaphore.getSignals());
        }
    }
}
