package com.wmm.designmode.prototype_mode.prototype_manager;

import java.util.Scanner;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 11:44
 */
public class Square implements Shape {
    @Override
    public Object clone() {
        Square square = null;
        try {
            square = (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return square;
    }

    @Override
    public void countArea() {
        int a = 0;
        System.out.print("这是一个正方形，请输入它的边长：");
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        System.out.println("该正方形的面积=" + a * a + "\n");
    }
}
