package com.wmm.designmode.adapter_mode.motor.adaptee;

/**
 * @author wangmingming160328
 * @Description 光能驱动的电动机
 * @date @2019/9/30 11:16
 */
public class OpticalMotor implements Motor{
    @Override
    public void fire() {
        System.out.println("光能发动机启动");
    }
}
