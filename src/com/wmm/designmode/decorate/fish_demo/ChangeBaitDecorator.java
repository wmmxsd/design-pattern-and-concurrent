package com.wmm.designmode.decorate.fish_demo;

/**
 * @author wangmingming160328
 * @Description 更换鱼饵修饰类
 * @date @2019/10/8 16:07
 */
public class ChangeBaitDecorator extends AbstractDecorator{
    public ChangeBaitDecorator(FisherMan fisherMan) {
        super(fisherMan);
    }

    /**
     * 钓鱼
     */
    @Override
    public void fishing() {
        changeBait();
        super.fishing();
    }

    /**
     * 更换鱼饵
     */
    private void changeBait() {
        System.out.println("更换使用过的鱼饵");
    }
}
