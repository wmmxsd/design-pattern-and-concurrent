package com.wmm.decorate.fish_demo;

/**
 * @author wangmingming160328
 * @Description 吸烟装饰类
 * @date @2019/10/8 15:53
 */
public class SmokeDecorator extends AbstractDecorator{
    SmokeDecorator(FisherMan fisherMan) {
        super(fisherMan);
    }

    /**
     * 钓鱼
     */
    @Override
    public void fishing() {
        smoking();
        super.fishing();
    }

    /**
     * 吸烟
     */
    private void smoking() {
        System.out.println("点燃了一根香烟");
    }
}
