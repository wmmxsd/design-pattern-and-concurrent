package com.wmm.static_demo;

/**
 * @author wangmingming160328
 * @Description 父类
 * @date @2019/7/15 17:58
 */
public class Parent {
    private static  int j = 1;

    public Parent() {
        System.out.println("父类构造函数");
    }

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类非静态代码块");
    }

    public void test() {
        System.out.println("test方法");
    }
}
