package com.wmm.designmode.prototype_mode;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 11:07
 */
public class AuditCar implements Cloneable{
    private String brandName;
    private int price;
    private String model;

    public AuditCar(){
        this.brandName = "Audit";
        this.price = 200000;
        this.model = "A8";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("奥迪A8拷贝成功！");
        return (AuditCar) super.clone();
    }

    @Override
    public String toString() {
        return "AuditCar{" + "brandName='" + brandName + '\'' + ", price=" + price + ", model='" + model + '\'' + '}';
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
