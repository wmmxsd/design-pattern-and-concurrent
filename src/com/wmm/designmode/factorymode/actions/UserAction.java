package com.wmm.designmode.factorymode.actions;

import com.wmm.designmode.factorymode.beans.Organization;
import com.wmm.designmode.factorymode.beans.User;
import com.wmm.designmode.factorymode.factory.factoryImpl.OrganizationService;
import com.wmm.designmode.factorymode.factory.factoryImpl.UserService;

import java.util.List;

public class UserAction {

    public static void main(String[] args) {
        UserService userService = new UserService();
        List<User> users = userService.queryAll();

        OrganizationService organizationService = new OrganizationService();
        List<Organization> organizations = organizationService.queryAll();
    }
}
