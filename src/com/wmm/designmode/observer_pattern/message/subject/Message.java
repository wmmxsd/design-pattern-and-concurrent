package com.wmm.designmode.observer_pattern.message.subject;

import com.wmm.designmode.observer_pattern.message.observer.Client;

/**
 * 消息公共接口
 * @author wmm
 */
public interface Message {
    /**
     * 设置消息
     * @param message 消息
     */
    void setMessage(String message);

    /**
     * 获得消息
     * @return  消息
     */
    String getMessage();

    /**
     * 添加订阅者
     * @param client 订阅的客户端
     */
    void add(Client client);

    /**
     * 移除订阅者
     * @param client 订阅的客户端
     */
    void remove(Client client);

    /**
     * 通知订阅者
     */
    void notifyObserver();
}
