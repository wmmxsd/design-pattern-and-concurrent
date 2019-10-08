package com.wmm.static_demo;

/**
 * @author wangmingming160328
 * @Description static关键字的使用demo
 * @date @2019/7/15 17:55
 */
public class StaticDemo extends Parent{
    private static  int i = 1;

    public StaticDemo() {
        System.out.println("构造函数");
    }

    static {
        System.out.println("静态代码块");
    }

     {
        System.out.println("非静态代码块");
    }

    @Override
    public void test() {
        System.out.println("静态方法");
    }

    public static void main(String[] args) {
        StaticDemo staticDemo = new StaticDemo();
        staticDemo.test();
    }
}
