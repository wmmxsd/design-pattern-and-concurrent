package com.wmm.concurrent.countdownlatch;

import com.wmm.concurrent.countdownlatch.serviceutil.ApplicationStartupUtil;

import java.util.concurrent.ExecutionException;

/**
 * CountDownLatch示例
 * CountDownLatch：倒计时器。具有一个倒计时值和countDown()和await()方法。
 * 线程池提交任务后，调用await()方法，使当前线程阻塞直到等待时间耗尽、倒计时值为0。
 * 其他若干线程执行完，finally调用countDown()将倒计时值减一，当为0时，唤醒主线程。
 * @author wangmingming160328
 * @Description
 * @date @2019/11/19 17:37
 */
public class MainService {
    public static void main(String[] args) {
        try {
            System.out.println("子服务启动完成，启动结果为：" + ApplicationStartupUtil.checkChildServices());
            System.out.println("开始启动主服务。。。。。。");
            Thread.sleep(2000L);
            System.out.println("主服务成功启动");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
