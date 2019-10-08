package com.wmm.concurrent.semaphore.countingsemaphore;


/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/22 19:15
 */
public class App {
    public static void main(String[] args) {
        CountingSemaphore countingSemaphore = new CountingSemaphore(1);

        SendingThread sender = new SendingThread(countingSemaphore);

        RecevingThread receiver = new RecevingThread(countingSemaphore);

        receiver.start();

        sender.start();
    }
}
