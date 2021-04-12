package com.zhangyu.designmode.delegate;

/**
 * @author : zhangyu
 * @description : 被委派者A
 * @date : 2021/4/13
 */
public class ExectorA implements ExectorIntf{

    @Override
    public void doing() {
        System.out.println("A做了");
    }
}
