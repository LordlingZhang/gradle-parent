package com.zhangyu.basics.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @description: Stream使用
 * @author: zhangyu
 * @date: 2020/12/10
 */
public class StreamMode {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // 过滤并遍历输出
        list.stream().filter(x -> x > 6).forEach(System.out::println);
    }
}
