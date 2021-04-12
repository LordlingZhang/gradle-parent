package com.zhangyu.designmode.delegate;

/**
 * @author : zhangyu
 * @description : 被委派者B
 * @date : 2021/4/13
 */
public class ExectorB implements ExectorIntf{

    @Override
    public void doing() {
        System.out.println("B做了");
    }
}
