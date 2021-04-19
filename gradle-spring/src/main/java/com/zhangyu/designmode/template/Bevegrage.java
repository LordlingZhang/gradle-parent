package com.zhangyu.designmode.template;

/**
 * @author : zhangyu
 * @description : 抽象类-泡茶饮
 * @date : 2021/4/19
 */
public abstract class Bevegrage {
    /**
     * 操作
     */
    public void process () {
        // 烧水
        boilWater();
        // 加材料
        addMaterial();
        // 冲水
        addWater();
        // 加辅料
        addExtraMaterial();
    }

    /**
     * 加材料
     */
    public abstract void addMaterial ();
    /**
     * 加辅料
     */
    public abstract void addExtraMaterial ();

    public void boilWater () {
        System.out.println("烧水------水开");
    }
    public void addWater () {
        System.out.println("加水");
    }
}
