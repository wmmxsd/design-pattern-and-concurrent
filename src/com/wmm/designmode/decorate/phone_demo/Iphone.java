package com.wmm.designmode.decorate.phone_demo;

public class Iphone implements Phone{
    @Override
    public void call() {
        System.out.println("用Iphone给某人打电话");
    }
}
