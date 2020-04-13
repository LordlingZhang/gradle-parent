package com.zhangyu.proxy.jdk.custom;

import com.zhangyu.proxy.jdk.Person;
import com.zhangyu.proxy.jdk.ZhangYu;

/**
 * 测试自定义动态戴丽丽
 */
public class ZYTestFindLove {

    /**
     * 自定义实现   JDK动态代理
     * @param args
     */
    public static void main(String[] args) {
        // 直接调用
//        new ZhangYu().findLove();
        // 媒婆调用（动态代理）
        Person person = (Person) new ZYMeipo().getInstance(new ZhangYu());
        System.out.println(person.getClass());
        person.findLove();
        // 原理:
        // 1.拿到被代理对象的引用，然后获取到它所有的接口
        // 2.JDK代理重新生成一个类，并且实现传的代理对象所实现的接口
        // 3.把代理对象的引用也拿到
        // 4.重新动态生成一个class字节码
        // 5.然后编译

    }
}
