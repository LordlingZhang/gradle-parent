package com.zhangyu.basics.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author : zhangyu
 * @description : person-实体类
 * @date : 2021/1/31
 */
@Data
@Builder
@AllArgsConstructor
public class PersonStream {
    /**
     * 姓名
     */
    private String name;
    // 薪资
    private int salary;
    // 年龄
    private int age;
    // 性别
    private String sex;
    // 地区
    private String area;

}
