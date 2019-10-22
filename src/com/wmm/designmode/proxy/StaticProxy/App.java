package com.wmm.designmode.proxy.StaticProxy;

public class App {
    public static void main(String[] args) {
        UserServiceProxy userServiceProxy = new UserServiceProxy(new UserService());
        userServiceProxy.save();
    }
}
