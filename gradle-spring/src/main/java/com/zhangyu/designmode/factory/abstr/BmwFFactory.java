package com.zhangyu.designmode.factory.abstr;

import com.zhangyu.designmode.factory.Bmw;
import com.zhangyu.designmode.factory.Car;

/**
 * @author : zhangyu
 * @description : 利用单独的工厂
 * @date : 2021/4/7
 */
public class BmwFFactory extends AbstractCarFactory{

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
