package com.wmm.designmode.adapter_mode.voltage_conversion.ac;

/**
 * 220V交流电
 *
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 17:53
 */
public class AC220 extends AbstractAC{
    public AC220() {
        output = 220;
    }

    @Override
    public int output2DC5() {
        //变压
        return output / 44;
    }
}
