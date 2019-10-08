package com.wmm.concurrent.memorymodel;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/18 10:32
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        methodOne();
    }

    public void methodOne() {
        //原始类型的本地变量(每个线程执行methodOne()都会在它们对应的线程栈上创建localVariable1和localVariable2的私有拷贝。
        // localVariable1变量彼此完全独立，仅“生活”在每个线程的线程栈上。一个线程看不到另一个线程对它的localVariable1私有拷贝做出的修改)
        int localVariable1 = 45;

        //引用类型的本地变量
        MySharedObject localVariable2 = MySharedObject.SHARED_INSTANCE;
        System.out.println(localVariable2.toString());
        //... do more with local variables.

        methodTwo();
    }

    public void methodTwo() {
        Integer localVariable1 = 99;

        //... do more with local variable.
    }
}
