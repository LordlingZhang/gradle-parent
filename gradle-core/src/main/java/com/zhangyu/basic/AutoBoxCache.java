package com.zhangyu.basic;

/**
 * @author zhangyu
 * @description: 自动装箱缓存
 * @date 2021/6/8
 */
public class AutoBoxCache {

    public static void main(String[] args) {
        // -128 ~ 127使用了缓存 (= 等同于 Integer.valueOf())
        Integer a = 128, b = 128, c = 127, d = 127;
        System.out.println(a==b);
        System.out.println(c==d);
        Integer.valueOf(1);


        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        Integer i3 = Integer.valueOf(1);
        // 结果：false。通过new创建，在内存中指向两个不同的对象
        System.out.println(i1 == i2);
    }
}
