package com.zhangyu.proxy.jdk;

import org.apache.commons.io.IOUtils;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description test class  jdk动态代理
 */
public class TestFindLove {
    public static void main(String[] args) {
        // 直接调用
//        new ZhangYu().findLove();
        // 媒婆调用（动态代理）
        Person person = (Person) new Meipo().getInstance(new ZhangYu());
        person.findLove();
        // 原理:
        // 1.拿到被代理对象的引用，然后获取到它所有的接口
        // 2.JDK代理重新生成一个类，并且实现传的代理对象所实现的接口
        // 3.把代理对象的引用也拿到
        // 4.重新动态生成一个class字节码
        // 5.然后编译

        // 创建class文件
        byte[] body = ProxyGenerator.generateProxyClass("$proxy1", new Class[]{Person.class});
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("D:\\zhangyu\\git_wk\\temp\\$proxy1.class");
            outputStream.write(body);
        } catch (IOException e) {
            IOUtils.closeQuietly(outputStream);
        }
    }
}
