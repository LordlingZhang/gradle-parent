package com.zhangyu.thread;

/**
 * @author zhangyu
 * @description thread alive
 * @date 2020/4/2
 */
public class MyThreadAlive extends Thread{
    /**
     * isAlive判断线程是否处于活动状态，已经启动，尚未终止
     */
    @Override
    public void run() {
        System.out.println("run:" + isAlive());
    }
}
