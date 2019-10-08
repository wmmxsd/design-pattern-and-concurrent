package com.wmm.designmode.adapter_mode.two_way_adapter.two_way_target;

import com.wmm.designmode.adapter_mode.two_way_adapter.two_way_adaptee.TwoWayAdaptee;
import com.wmm.designmode.adapter_mode.two_way_adapter.two_way_adapter.TwoWayTarget;

/**
 * @author wangmingming160328
 * @Description 双向适配器
 * @date @2019/10/8 11:01
 */
public class TwoWayAdapter implements TwoWayTarget, TwoWayAdaptee {
    /**
     * 目标
     */
    private TwoWayTarget target;

    /**
     * 适配者
     */
    private TwoWayAdaptee adaptee;

    public TwoWayAdapter(TwoWayTarget target) {
        this.target = target;
    }

    public TwoWayAdapter(TwoWayAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * 适配者方法
     */
    @Override
    public void specificRequest() {
        this.target.request();
    }

    /**
     * 目标接口方法
     */
    @Override
    public void request() {
        this.adaptee.specificRequest();
    }
}
