package com.zhangyu.designmode.prototype;

/**
 * @author : zhangyu
 * @description : ${描述}
 * @date : 2021/4/15
 */
public class Prototype implements Cloneable{
    /**
     * 重写父类的clone方法
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
