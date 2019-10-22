package com.wmm.designmode.agency.base_demo.colleague;

import com.wmm.designmode.agency.base_demo.agency.Agency;

/**
 * @author wangmingming160328
 * @Description 同事抽象类
 * @date @2019/10/9 18:55
 */
public abstract class Colleague {
    Agency agency;

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    /**
     * 接收信息方法
     */
    public abstract void receive();

    /**
     * 发送信息方法
     */
    public abstract void send();
}
