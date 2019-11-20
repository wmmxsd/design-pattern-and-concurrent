package com.wmm.concurrent.huangryandfair.nested_monitor_lockout;

/**
 * @author wangmingming160328
 * @Description lock implementation with nested monitor lockout problem(嵌套管程锁死)
 * @date @2019/7/18 16:56
 */


public class Lock{
    private final MonitorObject monitorObject = new MonitorObject();
    private boolean isLocked = false;

    void lock() throws InterruptedException{
        String name = Thread.currentThread().getName();
        System.out.println("lock()——" + name + "开始加锁，准备持有Lock对象");
        synchronized(this){
            System.out.println("***********lock()——" + name + "已经持有Lock对象***********");
            while(isLocked){
                System.out.println("lock()——" + name + "准备持有MonitorObject对象");
                synchronized(this.monitorObject){
                    System.out.println("lock()——" + name + "***********已经持有MonitorObject对象,马上释放MonitorObject对象并且持有Lock对象***********");
                    //调用monitorObject.wait()方法只释放了monitorObject上的管程对象，而与”this“关联的管程对象并没有释放
                    this.monitorObject.wait();
                }
            }
            isLocked = true;
        }
        System.out.println(name + "成功加锁");
    }

    void unlock(){
        String name = Thread.currentThread().getName();
        System.out.println("***********unlock()——" + name + "开始解锁，准备持有Lock对象***********");
        synchronized(this){
            System.out.println("unlock()——" + name + "已经持有Lock对象");
            this.isLocked = false;
            synchronized(this.monitorObject){
                this.monitorObject.notify();
            }
        }
        System.out.println("unlock()——" + name + "成功解锁");
    }
}
