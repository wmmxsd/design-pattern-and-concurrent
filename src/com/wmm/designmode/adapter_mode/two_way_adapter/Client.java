package com.wmm.designmode.adapter_mode.two_way_adapter;

import com.wmm.designmode.adapter_mode.two_way_adapter.two_way_adaptee.AdapteeRealize;
import com.wmm.designmode.adapter_mode.two_way_adapter.two_way_adaptee.TwoWayAdaptee;
import com.wmm.designmode.adapter_mode.two_way_adapter.two_way_adapter.TargetRealize;
import com.wmm.designmode.adapter_mode.two_way_adapter.two_way_adapter.TwoWayTarget;
import com.wmm.designmode.adapter_mode.two_way_adapter.two_way_target.TwoWayAdapter;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/8 10:44
 */
public class Client {
    public static void main(String[] args) {
        TwoWayAdaptee adaptee = new AdapteeRealize();
        TwoWayTarget target = new TwoWayAdapter(adaptee);
        target.request();

        target = new TargetRealize();
        adaptee = new TwoWayAdapter(target);
        adaptee.specificRequest();
    }
}
