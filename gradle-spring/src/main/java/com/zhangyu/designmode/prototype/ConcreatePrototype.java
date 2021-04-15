package com.zhangyu.designmode.prototype;

import lombok.Data;

/**
 * @author : zhangyu
 * @description : ${描述}
 * @date : 2021/4/15
 */
public class ConcreatePrototype extends Prototype{

    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
