package com.wmm.concurrent.atom;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/21 17:52
 */
public class AtomicStampedReferenceDemo {
    public static void main(String[] args) {
         int value = 1, stamp = 0;
        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(value, stamp);
        System.out.println("reference：" + stampedReference.getReference() + "; stamp：" + stampedReference.getStamp());

        boolean result = stampedReference.compareAndSet(value, 2, stamp, 1);
        System.out.println(result);
        System.out.println("reference：" + stampedReference.getReference() + "; stamp：" + stampedReference.getStamp());

        boolean result1 = stampedReference.compareAndSet(2, 3, 2, -1);
        System.out.println(result1);
        System.out.println("reference：" + stampedReference.getReference() + "; stamp：" + stampedReference.getStamp());
    }
}
