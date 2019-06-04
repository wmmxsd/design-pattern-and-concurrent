package com.wmm.proxy.StaticProxy;

public class UserServiceProxy implements BaseService{
    private UserService userService;

    public UserServiceProxy (UserService userService) {
        this.userService = userService;
    }

    @Override
    public void save () {
        userService.save();
        System.out.println("userService已经被监控");
    }
}
