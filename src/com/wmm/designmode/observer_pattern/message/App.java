package com.wmm.designmode.observer_pattern.message;

import com.wmm.designmode.observer_pattern.message.observer.AClient;
import com.wmm.designmode.observer_pattern.message.observer.BClient;
import com.wmm.designmode.observer_pattern.message.subject.AuditMessage;
import com.wmm.designmode.observer_pattern.message.subject.Message;

/**
 * @author wangmingming160328
 * @Description 主程序入口
 * @date @2019/10/9 16:13
 */
public class App {
    public static void main(String[] args) {
        Message message = new AuditMessage("服务器已上线");
        message.add(new AClient());
        message.add(new BClient());

        message.notifyObserver();

        message.setMessage("服务器已离线");
    }
}
