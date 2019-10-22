package com.wmm.designmode.singlemode;

public class SingletonByStaticInnerClass {
    private SingletonByStaticInnerClass() {
    }

    private static class LazyHolder {
        private static final SingletonByStaticInnerClass instanche = new SingletonByStaticInnerClass();
    }

    public SingletonByStaticInnerClass getInstanche () {
        return LazyHolder.instanche;
    }
}
