package com.wmm.designmode.observer_pattern.message.subject;

import com.wmm.designmode.observer_pattern.message.observer.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmingming160328
 * @Description 抽象消息类
 * @date @2019/10/9 16:18
 */
public abstract class AbstractMessage implements Message{
    private List<Client> clientList = new ArrayList<>();

    private String message;

    public AbstractMessage(String message) {
        this.message = message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
        notifyObserver();
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    /**
     * 添加订阅者
     *
     * @param client 订阅的客户端
     */
    @Override
    public void add(Client client) {
        this.clientList.add(client);
    }

    /**
     * 移除订阅者
     *
     * @param client 订阅的客户端
     */
    @Override
    public void remove(Client client) {
        this.clientList.remove(client);
    }

    public List<Client> getClientList() {
        return clientList;
    }
}
