package com.wmm.designmode.adapter_mode.two_way_adapter.two_way_adapter;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/8 11:00
 */
public class TargetRealize implements TwoWayTarget{
    @Override
    public void request() {
        System.out.println("目标代码被调用！");
    }
}
