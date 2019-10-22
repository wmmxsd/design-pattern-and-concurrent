package com.wmm.designmode.Iterator.iterator;

public interface Iterator<E> {
    /**
     * 是否有下一个元素
     * @return true：是
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     * @return 下一个元素
     */
    E next();

    /**
     * 获取第一个元素
     * @return 第一个元素
     */
    E first();
}
