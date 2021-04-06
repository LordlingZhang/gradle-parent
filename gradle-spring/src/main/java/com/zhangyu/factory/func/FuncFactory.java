package com.zhangyu.factory.func;

import com.zhangyu.factory.Car;

/**
 * @author : zhangyu
 * @description : 工厂方法模式
 * @date : 2021/4/7
 */
public interface FuncFactory {
    /**
     * 获取汽车
     * @return
     */
    Car getCar();
}
