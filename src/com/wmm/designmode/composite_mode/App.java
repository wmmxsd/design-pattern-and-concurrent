package com.wmm.designmode.composite_mode;

import com.wmm.designmode.composite_mode.component.BaseComponent;
import com.wmm.designmode.composite_mode.component.Composite;
import com.wmm.designmode.composite_mode.component.Leaf;

/**
 * <p><B>组合模式使得客户端代码可以一致地处理单个对象和组合对象，无须关心自己处理的是单个对象，还是组合对象，这简化了客户端代码</B></p>
 * <p>组合模式包含以下主要角色:</p>
 * <p>抽象构件（Component）角色：它的主要作用是为树叶构件和树枝构件声明公共接口，并实现它们的默认行为。在透明式的组合模式中抽象构件还声明访问和管理子类的接口；在安全式的组合模式中不声明访问和管理子类的接口，管理工作由树枝构件完成</p>
 * <p>树叶构件（Leaf）角色:是组合中的叶节点对象，它没有子节点，用于实现抽象构件角色中 声明的公共接口</p>
 * <p>树枝构件（Composite）角色:是组合中的分支节点对象，它有子节点。它实现了抽象构件角色中声明的接口，它的主要作用是存储和管理子部件，通常包含 Add()、Remove()、GetChild() 等方法。</p>
 *
 * @author wangmingming160328
 * @Description 组合模式
 * @date @2019/10/8 17:50
 */
public class App {
    public static void main(String[] args) {
        // 来一个根节点
        Composite root = new Composite("root");
        // 来一个树枝节点
        Composite branchA = new Composite("---branchA");
        Composite branchB = new Composite("------branchB");
        // 来一个叶子节点
        BaseComponent leafA = new Leaf("------leafA");
        BaseComponent leafB = new Leaf("---------leafB");
        BaseComponent leafC = new Leaf("---leafC");

        root.add(branchA);
        root.add(leafC);
        branchA.add(leafA);
        branchA.add(branchB);
        branchB.add(leafB);

        String result = root.operation();
        System.out.println(result);
    }
}
