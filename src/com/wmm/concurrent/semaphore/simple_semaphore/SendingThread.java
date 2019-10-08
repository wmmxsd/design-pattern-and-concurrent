package com.wmm.concurrent.semaphore.simple_semaphore;


/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/22 19:13
 */
public class SendingThread extends Thread{
    Semaphore semaphore = null;

    public SendingThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            //do something, then signal

            this.semaphore.take();
            System.out.println(Thread.currentThread().getName() + ":SendingThread");
            this.semaphore.release();
        }
    }
}
