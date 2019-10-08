package com.wmm.designmode.adapter_mode.voltage_conversion.ac;

/**
 * 110V交流电
 *
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 17:53
 */
public class AC110 extends AbstractAC{
    public AC110() {
        output = 110;
    }

    @Override
    public int output2DC5() {
        //变压
        return output / 22;
    }
}
