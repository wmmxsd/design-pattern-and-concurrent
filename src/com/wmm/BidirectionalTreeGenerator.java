package com.wmm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BidirectionalTreeGenerator {

    public static void main(String[] args) {
        Map<String, List<String>> bidirectionalData = new HashMap<>();
        List<String> a = new ArrayList<>();
        a.add("2");
        a.add("3");
        bidirectionalData.put("1", a);
        List<String> b = new ArrayList<>();
        b.add("3");
        b.add("4");
        bidirectionalData.put("2", b);
        List<String> c = new ArrayList<>();
        c.add("5");
        bidirectionalData.put("3", c);
        List<String> d = new ArrayList<>();
   /*     d.add("1");
        bidirectionalData.put("4", d);*/


        BidirectionalTreeGenerator treeBuilder = new BidirectionalTreeGenerator();
        TreeNode tree = treeBuilder.generateTree("1", bidirectionalData);
        printTree(tree, 0);
    }

    private static Map<String, TreeNode> visited;

    public BidirectionalTreeGenerator() {
        visited = new HashMap<>();
    }

    // 使用递归生成树
    public TreeNode generateTree(String root, Map<String, List<String>> bidirectionalData) {

        if (visited.containsKey(root)) {
            return visited.get(root);
        }

        TreeNode rootNode = new TreeNode(root);
        visited.put(root, rootNode);

        List<String> childrenData = bidirectionalData.get(root);
        if (childrenData != null) {
            for (String childValue : childrenData) {
                if (visited.containsKey(childValue)) {
                    // 子节点已经被标记为父节点，说明存在循环，可以进行相应处理
                    // 在这里我们直接跳过该子节点
                    continue;
                }
                TreeNode childNode = generateTree(childValue, bidirectionalData);
                rootNode.getChildren().add(childNode);
            }
        }

        return rootNode;
    }

    // 使用预购遍历打印树
    private static void printTree(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        // 根据节点的深度打印缩进
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }

        // 打印当前节点的值
        System.out.println(node.getValue());

        // 递归打印子节点
        for (TreeNode child : node.getChildren()) {
            printTree(child, depth + 1);
        }
    }
}
