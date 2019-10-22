package com.wmm.designmode.singlemode;

public class SingletonByDLC {
    private volatile static SingletonByDLC instance;

    private SingletonByDLC() {
    }

    public static SingletonByDLC getInstance() {
        if (instance == null) {
            synchronized (SingletonByDLC.class) {
                if (instance == null) {
                    instance = new SingletonByDLC();
                }
            }
        }
        return instance;
    }
}
