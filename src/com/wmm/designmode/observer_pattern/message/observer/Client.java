package com.wmm.designmode.observer_pattern.message.observer;

/**
 * 客户端公共接口
 * @author wmm
 */
public interface Client {
    /**
     * 对发送的消息做出反应
     * @param message 传递过来的消息
     */
    void response(String message);
}
