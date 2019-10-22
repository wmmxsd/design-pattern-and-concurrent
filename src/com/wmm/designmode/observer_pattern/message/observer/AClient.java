package com.wmm.designmode.observer_pattern.message.observer;

/**
 * @author wangmingming160328
 * @Description a客户端
 * @date @2019/10/9 16:24
 */
public class AClient implements Client{
    /**
     * 对发送的消息做出反应
     *
     * @param message 传递过来的消息
     */
    @Override
    public void response(String message) {
        System.out.println("A客户端接收到了消息：" + message);
    }
}
