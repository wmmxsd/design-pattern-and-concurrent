package com.wmm.concurrent.semaphore.simple_semaphore;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/22 19:15
 */
public class RecevingThread  extends Thread{

    Semaphore semaphore;

    public RecevingThread(Semaphore semaphore){

        this.semaphore = semaphore;

    }

    @Override
    public void run(){

        while(true){
            this.semaphore.take();
            System.out.println(Thread.currentThread().getName() + ":RecevingThread");
            this.semaphore.release();
        }

    }

}
