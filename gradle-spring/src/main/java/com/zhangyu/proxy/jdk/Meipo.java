package com.zhangyu.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理调用 Person
 */
public class Meipo implements InvocationHandler {

    private Person target;

    /**
     * 获取代理人的信息
     * 代理对象
     * @param target
     * @return
     */
    public Object getInstance(Person target){
        this.target = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start find");
//        this.target.findLove();
        // 直接调用
        method.invoke(this.target, args);
        System.out.println("end find");
        return null;
    }
}
