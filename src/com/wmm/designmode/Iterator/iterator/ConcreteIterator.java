package com.wmm.designmode.Iterator.iterator;

import java.util.List;

/**
 * @author wangmingming160328
 * @Description 具体的迭代器
 * @date @2019/10/11 10:16
 */
public class ConcreteIterator<E> extends AbstractIterator<E>{
    public ConcreteIterator(List<E> element) {
        super(element);
    }


}
