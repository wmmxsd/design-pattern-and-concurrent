package com.wmm.concurrent.huangryandfair.slippedconditions;

/**
 * 这个场景就是slipped conditions的例子，若isLocked为false，两个线程检查同一个条件， 然后退出同步块，因此在这两个线程改变条件之前，就允许其它线程来检查这个条件。
 * 换句话说，条件被某个线程检查到该条件被此线程改变期间，这个条件已经被其它线程改变过了。
 * 解决办法：条件的检查与设置必须是原子的
 * @author wangmingming160328
 * @Description 可能出现滑动条件问题的锁
 * @date @2019/7/18 19:03
 */
public class Lock {
    private boolean isLocked = true;

    public void lock(){
        synchronized(this){
            while(isLocked){
                try{
                    this.wait();
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

        synchronized(this){
            isLocked = true;
        }
    }

    public synchronized void unlock(){
        isLocked = false;
        this.notify();
    }
}
