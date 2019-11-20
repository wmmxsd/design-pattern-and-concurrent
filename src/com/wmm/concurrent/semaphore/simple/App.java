package com.wmm.concurrent.semaphore.simple;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/22 19:15
 */
public class App {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore();

        SendingThread sender = new SendingThread(semaphore);

        RecevingThread receiver = new RecevingThread(semaphore);

        receiver.start();

        sender.start();
    }
}
