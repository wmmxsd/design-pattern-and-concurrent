package com.wmm.designmode.adapter_mode.two_way_adapter.two_way_adaptee;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/8 10:58
 */
public class AdapteeRealize implements TwoWayAdaptee {
    @Override
    public void specificRequest() {
        System.out.println("适配者代码被调用！");
    }
}
