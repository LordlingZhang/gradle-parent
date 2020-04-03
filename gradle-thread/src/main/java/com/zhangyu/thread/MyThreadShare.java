package com.zhangyu.thread;

/**
 * @author zhangyu
 * @description 线程共享
 * @date 2020/3/30
 */
public class MyThreadShare extends Thread{

    private int count = 5;

    /**
     * 线程不安全 减
     */
    @Override
    public void run() {
        System.out.println(currentThread().getName() + ": " + count );
        // 会出现非线程安全问题
        count --;
    }

    public static class MyThreadShare1 extends Thread{

        private int count = 5;

        /**
         * 方法加锁
         * 加锁之后  方法称为  互斥区、临界区
         */
        @Override
        synchronized public void run() {
            System.out.println(currentThread().getName() + ": " + count );
            // 会出现非线程安全问题
            count --;
        }
    }
}
