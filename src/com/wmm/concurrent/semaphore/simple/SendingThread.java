package com.wmm.concurrent.semaphore.simple;


/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/22 19:13
 */
public class SendingThread extends Thread{
    private Semaphore semaphore = null;

    SendingThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            //do something, then signal
            this.semaphore.take();
            System.out.println(Thread.currentThread().getName() + ":SendingThread");
            this.semaphore.release();
            try {
                Thread.sleep(400L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
