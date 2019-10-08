package com.wmm.designmode.adapter_mode.motor.adapter;

import com.wmm.designmode.adapter_mode.motor.adaptee.Motor;
import com.wmm.designmode.adapter_mode.motor.adaptee.OpticalMotor;
import com.wmm.designmode.adapter_mode.motor.target_interface.Adapter;

/**
 * @author wangmingming160328
 * @Description 光能适配器
 * @date @2019/9/30 11:23
 */
public class OpticalAdapter implements Adapter {
    private Motor motor;

    public OpticalAdapter() {
        this.motor = new OpticalMotor();
    }

    @Override
    public void drive() {
        motor.fire();
    }
}
