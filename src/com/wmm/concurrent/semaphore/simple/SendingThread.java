package com.wmm.concurrent.semaphore.simple;


/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/22 19:13
 */
public class SendingThread extends Thread{
    private Semaphore semaphore = null;

    public SendingThread(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            //do something, then signal
            this.semaphore.take();
            this.semaphore.release();
            try {
                Thread.sleep(4000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
