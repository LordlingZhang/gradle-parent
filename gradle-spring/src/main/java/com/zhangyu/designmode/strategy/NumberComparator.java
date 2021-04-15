package com.zhangyu.designmode.strategy;

/**
 * @author : zhangyu
 * @description : 数字比较器
 * @date : 2021/4/15
 */
public class NumberComparator implements ComparatorIntf {


    /**
     * 比较大小，返回 0 1 -1
     *
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(Object o1, Object o2) {
        int a = (int) o1;
        int b = (int) o2;
        if (a > b) {
            return 1;
        } else if (a == b) {
            return 0;
        } else {
            return -1;
        }
    }
}
