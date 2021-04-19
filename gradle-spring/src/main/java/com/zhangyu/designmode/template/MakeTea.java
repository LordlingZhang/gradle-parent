package com.zhangyu.designmode.template;

/**
 * @author : zhangyu
 * @description : ${描述}
 * @date : 2021/4/19
 */
public class MakeTea extends Bevegrage{

    /**
     * 加材料
     */
    @Override
    public void addMaterial() {
        System.out.println("加茶叶");
    }

    /**
     * 加辅料
     */
    @Override
    public void addExtraMaterial() {
        System.out.println("加XXX");
    }
}
