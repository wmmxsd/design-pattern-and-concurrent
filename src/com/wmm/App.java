package com.wmm;

import com.wmm.designmode.factorymode.beans.User;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/8/13 10:38
 */
public class App {
    public static void main(String[] args) throws Exception {
        // 创建MBeanServer
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // 新建MBean ObjectName, 在MBeanServer里标识注册的MBean
        ObjectName name = new ObjectName("com.wmm.designmode.factorymode.beans:type=User");

        // 创建MBean
        User mbean = new User();

        // 在MBeanServer里注册MBean, 标识为ObjectName(com.tenpay.jmx:type=Echo)
        mbs.registerMBean(mbean, name);


        // 在MBeanServer里调用已注册的EchoMBean的print方法
        mbs.invoke(name, "print", new Object[] { "haitao.tu"}, new String[] {"java.lang.String"});

        Thread.sleep(Long.MAX_VALUE);
    }
}
