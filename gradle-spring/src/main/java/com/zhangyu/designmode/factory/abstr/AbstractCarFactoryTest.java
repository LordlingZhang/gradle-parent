package com.zhangyu.designmode.factory.abstr;

/**
 * @author : zhangyu
 * @description : 抽象工厂测试
 * @date : 2021/4/7
 */
public class AbstractCarFactoryTest {
    public static void main(String[] args) {
        DefaultFactory dd = new DefaultFactory();
        System.out.println(dd.getCar().getName());
        System.out.println(dd.getCar("Bmw").getName());
    }
}
