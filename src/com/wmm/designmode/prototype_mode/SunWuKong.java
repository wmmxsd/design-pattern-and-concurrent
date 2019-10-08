package com.wmm.designmode.prototype_mode;

import java.awt.*;
import javax.swing.*;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 11:01
 */
public class SunWuKong extends JPanel implements Cloneable {
    private static final long serialVersionUID = 5543049531872119328L;

    public SunWuKong() {
        JLabel l1 = new JLabel(new ImageIcon("E:\\work\\code\\ideaworkspace\\javathinking\\src\\Wukong.jpg"));
        this.add(l1);
    }

    @Override
    public Object   clone() {
        SunWuKong w = null;
        try {
            w = (SunWuKong) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝悟空失败!");
        }
        return w;
    }
}
