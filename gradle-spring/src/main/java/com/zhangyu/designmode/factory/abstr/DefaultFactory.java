package com.zhangyu.designmode.factory.abstr;

import com.zhangyu.designmode.factory.Car;

/**
 * @author : zhangyu
 * @description : ${描述}
 * @date : 2021/4/7
 */
public class DefaultFactory extends AbstractCarFactory{

    private AudiFFactory d = new AudiFFactory();

    /**
     * 获取
     *
     * @return
     */
    @Override
    protected Car getCar() {
        return d.getCar();
    }
}
