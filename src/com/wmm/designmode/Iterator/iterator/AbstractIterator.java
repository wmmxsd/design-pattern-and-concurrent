package com.wmm.designmode.Iterator.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmingming160328
 * @Description 抽象迭代器
 * @date @2019/10/11 9:40
 */
public abstract class AbstractIterator<E> implements Iterator<E>{
    /**
     * 索引
     */
    protected int index = -1;
    /**
     * 迭代器元素
     */
    protected List<E> element;

    public AbstractIterator(List<E> element) {
        this.element = element;
    }

    /**
     * 是否有下一个元素
     *
     * @return true：是
     */
    @Override
    public boolean hasNext() {
        return index < element.size() - 1;
    }

    /**
     * 获取下一个元素
     *
     * @return 下一个元素
     */
    @Override
    public E next() {
        if (hasNext()) {
            return element.get(++index);
        }
        return null;
    }

    /**
     * 获取第一个元素
     *
     * @return 第一个元素
     */
    @Override
    public E first() {
        index = 0;
        if (hasNext()) {
            return element.get(index);
        }
        return null;
    }
}
