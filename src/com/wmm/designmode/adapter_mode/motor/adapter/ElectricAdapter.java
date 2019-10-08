package com.wmm.designmode.adapter_mode.motor.adapter;

import com.wmm.designmode.adapter_mode.motor.adaptee.ElectricMotor;
import com.wmm.designmode.adapter_mode.motor.adaptee.Motor;
import com.wmm.designmode.adapter_mode.motor.target_interface.Adapter;

/**
 * @author wangmingming160328
 * @Description 电能适配器
 * @date @2019/9/30 11:23
 */
public class ElectricAdapter implements Adapter {
    private Motor motor;

    public ElectricAdapter() {
        this.motor = new ElectricMotor();
    }

    @Override
    public void drive() {
        motor.fire();
    }
}
