package com.wmm.designmode.adapter_mode.motor;

import com.wmm.designmode.adapter_mode.ReadXML;
import com.wmm.designmode.adapter_mode.motor.target_interface.Adapter;

/**
 * @author wangmingming160328
 * @Description 客户端
 * @date @2019/9/30 10:35
 */
public class Client {
    public static void main(String[] args) {
        Adapter adapter = (Adapter) ReadXML.getObject();
        assert adapter != null;
        adapter.drive();
    }
}
