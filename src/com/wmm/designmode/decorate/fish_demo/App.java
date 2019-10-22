package com.wmm.designmode.decorate.fish_demo;

/**
 * <b>装饰模式指在不改变现有对象结构的情况下，动态地给该对象增加一些职责（即增加其额外功能）的模式，它属于对象结构型模式</b>
 * <p>优点：</p>
 * <p>比采用继承方式更加灵活</p>
 * <p>可以设计出多个不同的具体装饰类，创造出多个不同行为的组合</p>
 * <p>缺点：</p>
 * <p>装饰模式增加了许多子类，如果过度使用会使程序变得很复杂，可读性差</p>
 * @author wangmingming160328
 * @Description
 * @date @2019/10/8 15:56
 */
public class App {
    public static void main(String[] args) {
        FisherMan fisherMan = new YoungFisherMan();
        fisherMan = new SmokeDecorator(fisherMan);
        fisherMan = new ChangeBaitDecorator(fisherMan);
        fisherMan.fishing();
    }
}
