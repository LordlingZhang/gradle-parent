package com.zhangyu.proxy.jdk.custom;

import java.lang.reflect.Method;

/**
 * 自定义代理
 */
public interface ZYInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
