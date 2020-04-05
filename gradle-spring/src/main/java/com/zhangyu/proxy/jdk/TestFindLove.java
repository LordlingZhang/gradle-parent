package com.zhangyu.proxy.jdk;

/**
 * @description test class
 */
public class TestFindLove {
    public static void main(String[] args) {
        // 直接调用
//        new ZhangYu().findLove();
        // 媒婆调用
        Person person = (Person) new Meipo().getInstance(new ZhangYu());
        person.findLove();
    }
}
