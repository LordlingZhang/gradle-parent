package com.zhangyu.basic.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * @author zhangyu
 * @description: lambda示例
 * @date 2021/7/23
 */
@Slf4j
public class LambdaDemo {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.forEach((Integer x) -> System.out.println(x));

        new Thread(() -> System.out.println("aa"));


        // 函数式接口，只有一个抽象方法，是SAM接口，即Single Abstract Method， 但是equals例外，这是重写的Object方法
        // 使用函数式接口的方法，可以简单理解为，= 后面的内容是接口的抽象方法的实现类
        // 1-1 构造方法（无参数），编译会做参数检查（包含输入参数和返回值）
        Supplier<LambdaDemo> supplier = LambdaDemo::new;
        supplier.get();
        // 1-2 构造方法（1个参数）
        IntFunction<LambdaDemo> intFunction = LambdaDemo::new;
        intFunction.apply(1);
        // 1-3 构造方法（多个参数）
        BiFunction<Integer, Integer, LambdaDemo> biFunction = LambdaDemo::new;
        biFunction.apply(1,2);
        // 2 静态方法
        Consumer<Integer> consumer = LambdaDemo::staticMethod;
        consumer.accept(3);
        // 3 实例方法
        IntConsumer integerIntConsumer = new LambdaDemo()::instanceMethod;
        integerIntConsumer.accept(4);
    }


    public LambdaDemo() {
        System.out.println("none parameters");
    }

    public LambdaDemo(int p1) {
        System.out.println("constructor whith one parameter: " + p1);
    }

    public LambdaDemo(Integer p1, Integer p2) {
        System.out.println(String.format("constructor whith 2 parameters %1s, %2s", p1, p2));
    }

    public static void staticMethod(Integer p1) {
        System.out.println("static method:" + p1);
    }

    public void instanceMethod(int p1) {
        System.out.println("instance method:"+p1);
    }

}
