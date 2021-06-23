package com.zhangyu.basic;

/**
 * @author zhangyu
 * @description: 初始化类
 * @date 2021/6/17
 */
public class InitialTest {

    /**
     * 静态变量只会初始化（执行）一次。
     * 父类静态变量（静态代码块）->子类静态变量（静态代码块）->父类非静态变量（非静态代码块）->父类构造器 ->子类非静态变量（非静态代码块）->子类构造器
     * @param args
     */
    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
    }
}

class A {
    String c;
    static { // 父类静态代码块
        System.out.print("A");
    }

    public A() { // 父类构造器
        System.out.print("a");
    }
    public A(String c) { // 父类构造器
        this.c = c;
        System.out.print("xx");
    }

    public void AA(){
    }

}

class B extends A {
    static { // 子类静态代码块
        System.out.print("B");
    }

    public B() { // 子类构造器
        System.out.print("b");
    }
}
