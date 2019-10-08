package com.wmm.designmode.adapter_mode.voltage_conversion.adapter;


import com.wmm.designmode.adapter_mode.voltage_conversion.ac.AC;

/**
 * 中国交流电适配器
 *
 * @author wangmingming160328
 * @date @2019/9/29 18:01
 */
public class ChinaAdapter implements DC5Adapter {
    @Override
    public int outoutTo5V(AC ac) {
       return ac.output2DC5();
    }
}
