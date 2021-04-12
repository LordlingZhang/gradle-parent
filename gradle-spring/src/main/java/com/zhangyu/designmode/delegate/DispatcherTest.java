package com.zhangyu.designmode.delegate;

/**
 * @author : zhangyu
 * @description : 委派模式测试类
 * @date : 2021/4/13
 */
public class DispatcherTest {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(new ExectorA());
        // 看似是dispatcher在执行，其实是Exector在执行
        // 委派模式只关心结果，不注重过程
        dispatcher.doing();
    }
}
