package com.zhangyu.factory.func;

import com.zhangyu.factory.Bmw;
import com.zhangyu.factory.Car;

/**
 * @author : zhangyu
 * @description : 利用单独的工厂
 * @date : 2021/4/7
 */
public class BmwFactory implements FuncFactory{

    /**
     * 获取汽车
     *
     * @return
     */
    @Override
    public Car getCar() {
        return new Bmw();
    }
}
