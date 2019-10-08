package com.wmm.designmode.adapter_mode.motor.adaptee;

/**
 * @author wangmingming160328
 * @Description 电能驱动的电动机
 * @date @2019/9/30 11:15
 */
public class ElectricMotor implements Motor {
    @Override
    public void fire() {
        System.out.println("电能发动机启动");
    }
}
