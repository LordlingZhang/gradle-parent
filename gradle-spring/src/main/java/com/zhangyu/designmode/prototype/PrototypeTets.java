package com.zhangyu.designmode.prototype;

/**
 * @author : zhangyu
 * @description : 原型模式测试类
 * @date : 2021/4/15
 */
public class PrototypeTets {

    public static void main(String[] args) throws CloneNotSupportedException {
        ConcreatePrototype concreatePrototype = new ConcreatePrototype();
        concreatePrototype.setAge("21");

        ConcreatePrototype c = (ConcreatePrototype) concreatePrototype.clone();
        System.out.println(c.getAge());
    }
}
