package com.wmm.designmode.Iterator.aggregation;

import com.wmm.designmode.Iterator.iterator.Iterator;

public interface Aggregation<E> {
    /**
     * 添加
     * @param e 被添加的元素
     */
    void add(E e);

    /**
     * 移除元素
     * @param e 被移除的元素
     */
    void remove(E e);

    /**
     * 获取迭代器
     * @return 该聚合类的迭代器
     */
    Iterator<E> iterator();
}
