package com.wmm.decorate.fish_demo;

/**
 * @author wangmingming160328
 * @Description 抽象装饰类
 * @date @2019/10/8 15:42
 */
class AbstractDecorator implements FisherMan {
    private FisherMan fisherMan;

    public AbstractDecorator(FisherMan fisherMan) {
        this.fisherMan = fisherMan;
    }

    /**
     * 钓鱼
     */
    @Override
    public void fishing() {
        fisherMan.fishing();
    }
}
