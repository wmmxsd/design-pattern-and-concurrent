package com.wmm;


import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private String value;
    private List<TreeNode> children;

    public TreeNode(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
