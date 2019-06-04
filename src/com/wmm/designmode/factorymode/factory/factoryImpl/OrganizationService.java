package com.wmm.designmode.factorymode.factory.factoryImpl;

import com.wmm.designmode.factorymode.beans.Organization;
import com.wmm.designmode.factorymode.factory.BaseService;

import java.util.ArrayList;
import java.util.List;

public class OrganizationService implements BaseService<Organization> {
    @Override
    public List<Organization> queryAll() {
        System.out.println("OrganizationService queryAll");
        return new ArrayList<>();
    }
}
