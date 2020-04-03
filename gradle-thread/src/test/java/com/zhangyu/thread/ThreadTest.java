package com.zhangyu.thread;

import org.junit.Test;

/**
 * @author zhangyu
 * @description thread test
 * @date 2020/4/1
 */
public class ThreadTest {

    @Test
    public void myThreadNoShare(){
        MyThreadNoShare share1 = new MyThreadNoShare("A");
        MyThreadNoShare share2 = new MyThreadNoShare("B");
        MyThreadNoShare share3 = new MyThreadNoShare("C");
        share1.start();
        share2.start();
        share3.start();
    }
    @Test
    public void myThreadShare(){
        MyThreadShare thread = new MyThreadShare();
        Thread share1 = new Thread(thread, "A");
        Thread share2 = new Thread(thread,"B");
        Thread share3 = new Thread(thread, "C");
        share1.start();
        share2.start();
        share3.start();
    }
    @Test
    public void myThreadShare1(){
        MyThreadShare.MyThreadShare1 thread = new MyThreadShare.MyThreadShare1();
        Thread share1 = new Thread(thread, "A");
        Thread share2 = new Thread(thread,"B");
        Thread share3 = new Thread(thread, "C");
        share1.start();
        share2.start();
        share3.start();
    }
    @Test
    public void myThreadAlive() throws InterruptedException {
        MyThreadAlive thread = new MyThreadAlive();
        System.out.println("begin-" + thread.isAlive());
        thread.start();
        System.out.println("end-" + thread.isAlive());
        Thread.sleep(2000);
        System.out.println("end1-" + thread.isAlive());
    }



}
