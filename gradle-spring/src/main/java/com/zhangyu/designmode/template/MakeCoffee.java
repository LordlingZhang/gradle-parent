package com.zhangyu.designmode.template;

/**
 * @author : zhangyu
 * @description : 冲咖啡
 * @date : 2021/4/19
 */
public class MakeCoffee extends Bevegrage{

    /**
     * 加材料
     */
    @Override
    public void addMaterial() {
        System.out.println("加咖啡");
    }

    /**
     * 加辅料
     */
    @Override
    public void addExtraMaterial() {
        System.out.println("加牛奶");
    }
}
