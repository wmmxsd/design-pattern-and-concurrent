package com.wmm.designmode.prototype_mode.prototype_manager;

import java.util.Scanner;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 11:42
 */
public class Circle implements Shape {
    @Override
    public Object clone() {
        Circle circle = null;
        try {
            circle = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return circle;
    }

    @Override
    public void countArea() {
        int r = 0;
        System.out.print("这是一个圆，请输入圆的半径：");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("该圆的面积=" + 3.1415 * r * r + "\n");
    }
}
