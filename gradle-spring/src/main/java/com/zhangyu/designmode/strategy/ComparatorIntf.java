package com.zhangyu.designmode.strategy;

/**
 * @author : zhangyu
 * @description : ${描述}
 * @date : 2021/4/15
 */
public interface ComparatorIntf {
    /**
     * 比较大小，返回 0 1 -1
     * @param o1
     * @param o2
     * @return
     */
    int compare(Object o1, Object o2);

}
