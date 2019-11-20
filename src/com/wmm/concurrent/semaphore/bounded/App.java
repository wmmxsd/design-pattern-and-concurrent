package com.wmm.concurrent.semaphore.bounded;


/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/22 19:15
 */
public class App {
    public static void main(String[] args) {
        BoundedSemaphore boundedSemaphore = new BoundedSemaphore(1);

        SendingThread sender = new SendingThread(boundedSemaphore);

        RecevingThread receiver = new RecevingThread(boundedSemaphore);

        receiver.start();

        sender.start();
    }
}
