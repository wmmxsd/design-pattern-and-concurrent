package com.wmm.designmode.observer_pattern.message.subject;

import com.wmm.designmode.observer_pattern.message.observer.Client;

/**
 * @author wangmingming160328
 * @Description 审计消息
 * @date @2019/10/9 16:21
 */
public class AuditMessage extends AbstractMessage{

    public AuditMessage(String message) {
        super(message);
    }

    /**
     * 通知订阅者
     */
    @Override
    public void notifyObserver() {
        for (Client client : getClientList()) {
            client.response(getMessage());
        }
    }
}
