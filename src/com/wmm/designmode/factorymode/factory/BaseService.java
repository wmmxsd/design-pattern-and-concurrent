package com.wmm.designmode.factorymode.factory;

import java.util.List;

public interface BaseService<E> {
    List<E> queryAll();
}
