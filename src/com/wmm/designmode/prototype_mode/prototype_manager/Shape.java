package com.wmm.designmode.prototype_mode.prototype_manager;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 11:40
 */
interface Shape extends Cloneable{
    /**
     * 克隆
     * @return Obj
     */
    public Object clone();

    /**
     * 计算面积
     */
    public void countArea();
}
