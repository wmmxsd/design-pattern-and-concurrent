package com.wmm.designmode.adapter_mode.voltage_conversion;

import com.wmm.designmode.adapter_mode.voltage_conversion.ac.AC110;
import com.wmm.designmode.adapter_mode.voltage_conversion.ac.AC220;
import com.wmm.designmode.adapter_mode.voltage_conversion.adapter.ChinaAdapter;
import com.wmm.designmode.adapter_mode.voltage_conversion.adapter.DC5Adapter;
import com.wmm.designmode.adapter_mode.voltage_conversion.adapter.JapanAdapter;

/**
 * 手机充电
 *
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 20:01
 */
public class App {
    public static void main(String[] args) {
        DC5Adapter chinaAdapter = new ChinaAdapter();
        int voltage = chinaAdapter.outoutTo5V(new AC220());
        System.out.println(voltage);

        DC5Adapter japanAdapter = new JapanAdapter();
        voltage = japanAdapter.outoutTo5V(new AC110());
        System.out.println(voltage);
    }
}
