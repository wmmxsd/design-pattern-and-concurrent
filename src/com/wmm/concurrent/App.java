package com.wmm.concurrent;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/23 14:57
 */
public class App {
    public static void main(String[] args) {
        int i = 0;
        do {
            i++;
        } while (i < 10);
        System.out.println(i);
    }
}
