package com.zhangyu.sourcecode;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : zhangyu
 * @description : 测试xml方式加载类到容器
 * @date : 2021/4/27
 */
public class SimpleBookTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        SimpleBook book = context.getBean(SimpleBook.class);
        System.out.println(book.getName());
    }
}
