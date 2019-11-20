package com.wmm.concurrent.theadlocal;

import java.lang.ref.WeakReference;

/**
 * @author wangmingming160328
 * @Description 弱引用特点
 * @date @2019/11/7 16:42
 */
public class WeakReferenceDemo {
    private static WeakReference<String> weakReference;

    public static void main(String[] args) {
        gcTest();
        //可以输出hello值，此时两个弱引用扔持有对象，而且未进行gc
        System.out.println("未进行gc时，只有弱引用指向value内存区域：" + weakReference.get());

        //此时已无强一用执行"value"所在内存区域，gc时会回收弱引用
        System.gc();

        //此时输出都为null
        System.out.println("进行gc时，只有弱引用指向value内存区域：" + weakReference.get());
    }
    private static void gcTest() {
        String helloWorld = new String("HelloWorld");
        weakReference = new WeakReference<>(helloWorld);
        System.gc();
        //此时gc不会回收弱引用，因为字符串"value"仍然被hello对象强引用
        System.out.println("进行gc时，强引用与弱引用同时指向value内存区域：" + weakReference.get());
    }
}
