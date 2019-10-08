package com.wmm.designmode.prototype_mode.prototype_manager;

import java.util.HashMap;

/**
 * 原型管理类
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 11:45
 */
public class ProtoTypeManager {
    private HashMap<String, Shape> shapeHashMap = new HashMap<>();

    public ProtoTypeManager() {
        this.shapeHashMap.put("Circle",new Circle());
        this.shapeHashMap.put("Square",new Square());
    }

    public void addShape(String key, Shape shape) {
        shapeHashMap.put(key, shape);
    }

    public Shape getShape(String key) {
        Shape shape = shapeHashMap.get(key);
        return (Shape) shape.clone();
    }
}
