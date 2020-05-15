package com.wmm.concurrent.keywordaboutlock;

/**
 * @author wangmingming160328
 * @Description 双重检查单例模式
 * @date @2020/5/14 10:39
 */
public class SingleTon {
    private static volatile SingleTon instance;

    private SingleTon() {
    }

    public static SingleTon getInstance() {
        if (instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }
}
