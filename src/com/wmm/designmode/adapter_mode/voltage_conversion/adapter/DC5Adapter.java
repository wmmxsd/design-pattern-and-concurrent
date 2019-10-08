package com.wmm.designmode.adapter_mode.voltage_conversion.adapter;

import com.wmm.designmode.adapter_mode.voltage_conversion.ac.AC;

/**
 * 5V直流电接口
 *
 * @author wmm
 * @date 2019年9月29日17:58:18
 */
public interface DC5Adapter {

    /**
     * 交流电转换为5V直流电
     * @param ac 交流电压
     * @return /44后的商
     */
    int outoutTo5V(AC ac);
}
