package com.wmm.decorate.fish_demo;

/**
 * 年轻的渔夫
 *
 * @author wangmingming160328
 * @Description 年轻的渔夫
 * @date @2019/10/8 15:30
 */
public class YoungFisherMan implements FisherMan{
    /**
     * 钓鱼
     */
    @Override
    public void fishing() {
        System.out.println("一位年轻的渔夫正在钓鱼");
    }
}
