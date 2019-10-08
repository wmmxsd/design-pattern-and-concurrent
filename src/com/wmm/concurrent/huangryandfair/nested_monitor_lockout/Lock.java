package com.wmm.concurrent.huangryandfair.nested_monitor_lockout;

/**
 * @author wangmingming160328
 * @Description lock implementation with nested monitor lockout problem(嵌套管程锁死)
 * @date @2019/7/18 16:56
 */


public class Lock{
    protected MonitorObject monitorObject = new MonitorObject();
    protected boolean isLocked = false;

    public void lock() throws InterruptedException{
        String name = Thread.currentThread().getName();
        synchronized(this){
            while(isLocked){
                synchronized(this.monitorObject){
                    this.monitorObject.wait();
                    System.out.println("this.monitorObject");
                }
                System.out.println(name + "： 释放monitorObject的锁");
            }
            isLocked = true;
            System.out.println("this");
        }
        System.out.println(name + "： 释放this的锁");
    }

    public void unlock(){
        synchronized(this){
            this.isLocked = false;
            synchronized(this.monitorObject){
                this.monitorObject.notify();
            }
        }
    }
}
