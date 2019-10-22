package com.wmm.designmode.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    //维护一个目标对象
    private Object target;

    public ProxyFactory (Object target) {
        this.target = target;
    }

    //生成代理对象
    public Object getTargetPorxyInstance () {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("开始事务");
            //执行目标对象方法
            Object returnValue = method.invoke(target, args);
            System.out.println("提交事务");
            return returnValue;
        });
    }
}

