package com.zhangyu.designmode.singleton;

/**
 * @author : zhangyu
 * @description : 懒汉加载、静态内部类
 * @date : 2021/4/7
 */
public class Singleton1 {
    // static 保证全局唯一
    private static class AA {
        private static final Singleton1 INSTANCE = new Singleton1();
    }

    private Singleton1(){};

    /**
     * 提供静态方法获取实例
     * final确保别人不能覆盖
     * @return
     */
    public static final Singleton1 getInstance() {
//        a = 122;
        return AA.INSTANCE;
    }

//    private void aaa (){
//        a = 214;
//    }

    // 解释类在JVM中的加载过程
    // 从上往下
    // 先变量后方法
    // 先静态后动态
    //
//    int a;
}
