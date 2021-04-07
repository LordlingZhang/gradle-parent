package com.zhangyu.designmode.factory.simple;

import com.zhangyu.designmode.factory.Car;

/**
 * @author : zhangyu
 * @description : 简单car工厂模式 测试类
 * @date : 2021/4/6
 */
public class SimpleCarFactoryTest {

    public static void main(String[] args) {
        // 获取一个汽车
        Car car =new SimpleCarFactory().getCar("Bmw");
        System.out.println(car.getName());
    }

}
