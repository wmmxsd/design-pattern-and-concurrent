package com.wmm.concurrent.memorymodel;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/7/18 10:31
 */
public class MySharedObject {
    /**
     * static variable pointing to instance of MySharedObject
     */
    public static final MySharedObject SHARED_INSTANCE = new MySharedObject();

    /**
     *  member variables pointing to two objects on the heap
     */
    public Integer object2 = 22;
    public Integer object4 = 44;

    public long member1 = 12345;
}
