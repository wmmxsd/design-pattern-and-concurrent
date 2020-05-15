package com.wmm.designmode.singlemode;

import com.wmm.concurrent.keywordaboutlock.SingleTon;

/**
 * @author wangmingming160328
 * @Description
 * @date @2020/5/15 16:43
 */
public class Singleton {
    private Singleton() {}

    private static class Single {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Single.INSTANCE;
    }

    public static void main(String[] args) {
        SingleTon singleTon1 = SingleTon.getInstance();
        SingleTon singleTon2 = SingleTon.getInstance();
        System.out.println(singleTon1 == singleTon1);
    }
}
