package com.wmm.designmode.Iterator.aggregation;

import com.wmm.designmode.Iterator.iterator.AbstractIterator;
import com.wmm.designmode.Iterator.iterator.ConcreteIterator;
import com.wmm.designmode.Iterator.iterator.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmingming160328
 * @Description 抽象聚合类
 * @date @2019/10/11 9:36
 */
public abstract class AbstractAggregation<E> implements Aggregation<E> {
    protected List<E> list=new ArrayList<>();

    /**
     * 添加
     *
     * @param e 被添加的元素
     */
    @Override
    public void add(E e) {
        list.add(e);
    }

    /**
     * 移除元素
     *
     * @param e 被移除的元素
     */
    @Override
    public void remove(E e) {
        list.remove(e);
    }

    /**
     * 获取迭代器
     *
     * @return 该聚合类的迭代器
     */
    @Override
    public Iterator<E> iterator() {
        return new ConcreteIterator<>(list);
    };
}
