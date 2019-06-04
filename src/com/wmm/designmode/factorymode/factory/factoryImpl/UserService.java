package com.wmm.designmode.factorymode.factory.factoryImpl;

import com.wmm.designmode.factorymode.beans.User;
import com.wmm.designmode.factorymode.factory.BaseService;

import java.util.ArrayList;
import java.util.List;

public class UserService implements BaseService<User> {
    @Override
    public List<User> queryAll() {
        System.out.println("UserService queryAll");
        return new ArrayList<>();
    }
}
