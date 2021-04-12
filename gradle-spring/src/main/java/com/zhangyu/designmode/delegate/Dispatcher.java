package com.zhangyu.designmode.delegate;

/**
 * @author : zhangyu
 * @description : 委派者
 * @date : 2021/4/13
 */
public class Dispatcher implements ExectorIntf{

    ExectorIntf exectorIntf;

    public Dispatcher (ExectorIntf exector) {
        this.exectorIntf = exector;
    }



    @Override
    public void doing() {
        exectorIntf.doing();
    }
}
