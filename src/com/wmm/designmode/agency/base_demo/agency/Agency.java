package com.wmm.designmode.agency.base_demo.agency;

import com.wmm.designmode.agency.base_demo.colleague.Colleague;

/**
 * 中介者公共方法接口
 * 抽象中介者（Mediator）角色：它是中介者的接口，提供了同事对象注册与转发同事对象信息的抽象方法
 *
 * @author wmm
 */
public interface Agency {
    /**
     * 同时对象注册方法
     * @param colleague 同事对象
     */
    public void register(Colleague colleague);

    /**
     * 转发消息
     * @param colleague 同事
     */
    void relay(Colleague colleague);
}
