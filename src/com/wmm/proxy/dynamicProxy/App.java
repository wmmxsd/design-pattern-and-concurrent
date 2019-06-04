package com.wmm.proxy.dynamicProxy;

import com.wmm.proxy.StaticProxy.BaseService;
import com.wmm.proxy.StaticProxy.UserService;

public class App {
    public static void main(String[] args) {
        BaseService target = new UserService();
//        if (target instanceof UserService) {
//            System.out.println(true);
//        } else {
//            System.out.println(false);
//        }
//        System.out.println(target.getClass());
        ProxyFactory proxyFactory = new ProxyFactory(target);
        BaseService proxy = (BaseService)proxyFactory.getTargetPorxyInstance();
//        System.out.println(com.wmm.proxy.getClass());
        proxy.save();
    }
}
