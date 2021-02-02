package com.zhangyu.basics.stream;

import com.zhangyu.proxy.jdk.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: Stream使用
 * @author: zhangyu
 * @date: 2020/12/10
 */
public class StreamMode {

    public static void main(String[] args) {
        /*List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // 过滤并遍历输出
        list.stream().filter(x -> x > 6).forEach(System.out::println);
        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();
        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x < 6);
        System.out.println("匹配第一个值：" + findFirst.get());
        System.out.println("匹配任意一个值：" + findAny.get());
        System.out.println("是否存在大于6的值：" + anyMatch);*/

        List<PersonStream> personList = new ArrayList<>();
        personList.add(new PersonStream("Tom", 8900, 23, "male", "New York"));
        personList.add(new PersonStream("Jack", 7000, 25, "male", "Washington"));
        personList.add(new PersonStream("Lily", 7800, 21, "female", "Washington"));
        personList.add(new PersonStream("Anni", 8200, 24, "female", "New York"));
        personList.add(new PersonStream("Owen", 9500, 25, "male", "New York"));
        personList.add(new PersonStream("Alisa", 7900, 26, "female", "New York"));

        List<String> fiterList = personList.stream().filter(x -> x.getSalary() > 8000).map(PersonStream::getName)
                .collect(Collectors.toList());
        System.out.print("高于8000的员工姓名：" + fiterList);


        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());
    }
}
