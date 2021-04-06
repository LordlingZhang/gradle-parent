package com.zhangyu.factory.func;

import com.zhangyu.factory.Bmw;

/**
 * @author : zhangyu
 * @description : ${描述}
 * @date : 2021/4/7
 */
public class FuncFactoryTest {

    public static void main(String[] args) {
        // 工厂方法模式
        FuncFactory factory = new BmwFactory();
        System.out.println(factory.getCar().getName());

        factory = new AudiFactory();
        System.out.println(factory.getCar().getName());
    }
}
