package proxy.dynamicProxy;

import proxy.StaticProxy.BaseService;
import proxy.StaticProxy.UserService;

public class App {
    public static void main(String[] args) {
        BaseService target = new UserService();
        if (target instanceof UserService) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        System.out.println(target.getClass());
        ProxyFactory proxyFactory = new ProxyFactory(target);
        BaseService proxy = (BaseService)proxyFactory.getTargetPorxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }
}
