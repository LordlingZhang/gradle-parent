package com.zhangyu.basic;

/**
 * @author zhangyu
 * @description: 基础案例
 * @date 2021/6/8
 */
public class BasicCase {

    public static void main(String[] args) {
        // short转换比较
        short a = 1;
//        a = 1 + a; // 1 + a为int，转short可能会有损失
        a += 1; // 等同于 (short)(1 + a)
    }

    /**
     * String\StringBuffer\StringBuilder
      */
    public void mString() {
        // 线程安全，使用synchronized
        StringBuffer ss = new StringBuffer();
        ss.append("aa");
        // 非线程安全，性能高，推荐使用
        StringBuilder sb = new StringBuilder();
        sb.append("bb");

    }
}
