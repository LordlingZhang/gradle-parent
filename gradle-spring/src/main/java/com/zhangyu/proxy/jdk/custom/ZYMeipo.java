package com.zhangyu.proxy.jdk.custom;

import com.zhangyu.proxy.jdk.Person;

import java.lang.reflect.Method;

/**
 * 自定义 动态代理
 */
public class ZYMeipo implements ZYInvocationHandler{
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
        return ZYProxy.newProxyInstance(new ZYClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start zyfind");
//        this.target.findLove();
        // 直接调用
        method.invoke(this.target, args);
        System.out.println("end zyfind");
        return null;
    }
}
