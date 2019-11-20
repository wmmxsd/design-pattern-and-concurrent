package com.wmm.concurrent.semaphore.simple;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/22 19:15
 */
public class RecevingThread  extends Thread{

    private Semaphore semaphore;

    RecevingThread(Semaphore semaphore){

        this.semaphore = semaphore;

    }

    @Override
    public void run(){

        while(true){
            this.semaphore.take();
            System.out.println(Thread.currentThread().getName() + ":RecevingThread");
            this.semaphore.release();
            try {
                Thread.sleep(400L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
