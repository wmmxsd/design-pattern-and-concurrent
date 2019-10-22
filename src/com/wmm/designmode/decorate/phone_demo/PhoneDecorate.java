package com.wmm.designmode.decorate.phone_demo;

/**
 * 装饰器，实现接口
 */
abstract class PhoneDecorate implements Phone{
    /**
     * 以组合的方式获取要实现的类
     */
    private Phone phone;
    PhoneDecorate(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void call() {
        phone.call();
    }
}
