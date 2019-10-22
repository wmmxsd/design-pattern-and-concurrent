package com.wmm.designmode.agency.base_demo.colleague;

/**
 * @author wangmingming160328
 * @Description vrv同事
 * @date @2019/10/10 10:13
 */
public class OtherColleague extends Colleague{
    /**
     * 发送信息方法
     */
    @Override
    public void send() {
        System.out.println("其他同事发送请求");
        this.agency.relay(this);
    }

    /**
     * 接收信息方法
     */
    @Override
    public void receive() {
        System.out.println("其他同事已经接收到消息");
    }
}
