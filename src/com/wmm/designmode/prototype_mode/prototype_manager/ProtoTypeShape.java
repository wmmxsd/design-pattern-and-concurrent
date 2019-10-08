package com.wmm.designmode.prototype_mode.prototype_manager;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 11:55
 */
public class ProtoTypeShape {
    public static void main(String[] args) {
        ProtoTypeManager protoTypeManager = new ProtoTypeManager();
        Shape circleShape = protoTypeManager.getShape("Circle");
        circleShape.countArea();
        Shape squareShape = protoTypeManager.getShape("Square");
        squareShape.countArea();
    }
}
