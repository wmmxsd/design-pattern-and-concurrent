package com.wmm.concurrent.producerconsumerproblem.blockingqueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author wangmingming160328
 * @Description 阻塞队列接口
 * @date @2020/5/15 11:48
 */
public class Quene {
    static LinkedBlockingQueue<Object> QUENE = new LinkedBlockingQueue<>(10);
}
