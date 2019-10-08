package com.wmm.designmode.prototype_mode;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 11:12
 */
public class AuditCarApp {
    public static void main(String[] args) throws CloneNotSupportedException {
        AuditCar auditCar = new AuditCar();
        String s1 = auditCar.toString();
       System.out.println(s1);

        AuditCar auditCar1 = (AuditCar) auditCar.clone();
        auditCar1.setPrice(210000);
        String s2 = auditCar1.toString();
        System.out.println(s2);
    }
}
