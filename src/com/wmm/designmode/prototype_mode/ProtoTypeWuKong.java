package com.wmm.designmode.prototype_mode;

import javax.swing.*;
import java.awt.*;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 11:04
 */
public class ProtoTypeWuKong {
    public static void main(String[] args)
    {
        JFrame jf=new JFrame("原型模式测试");
        jf.setLayout(new GridLayout(1,2));
        Container contentPane=jf.getContentPane();
        SunWuKong obj1=new SunWuKong();
        contentPane.add(obj1);
        SunWuKong obj2=(SunWuKong)obj1.clone();
        contentPane.add(obj2);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
