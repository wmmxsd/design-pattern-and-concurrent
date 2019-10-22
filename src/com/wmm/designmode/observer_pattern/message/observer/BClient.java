package com.wmm.designmode.observer_pattern.message.observer;

/**
 * @author wangmingming160328
 * @Description b客户端
 * @date @2019/10/9 16:24
 */
public class BClient implements Client{
    /**
     * 对发送的消息做出反应
     *
     * @param message 传递过来的消息
     */
    @Override
    public void response(String message) {
        System.out.println("B客户端接收到了消息：" + message);
    }
}
