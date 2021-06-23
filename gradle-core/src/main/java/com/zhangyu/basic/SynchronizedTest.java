package com.zhangyu.basic;

/**
 * @author zhangyu
 * @description: 同步锁
 * @date 2021/6/22
 */
public class SynchronizedTest {

    public synchronized void test1() {
        int count = 5;
        for (int i = 0; i < 5; i++) {
            count--;
            System.out.println(Thread.currentThread().getName() + " - " + count);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

    public void test2() {
        synchronized (this) {
            System.out.println("代码块，传入的参数this，那么锁定的也是当前的对象");
        }
    }


    public static synchronized void test3() {
        int count = 5;
        for (int i = 0; i < 5; i++) {
            count--;
            System.out.println(Thread.currentThread().getName() + " - " + count);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

    public void test4() {
        synchronized (SynchronizedTest.class) {
            System.out.println("使用代码块，需引用当前的类");
        }
    }



    public void test5() {
        int count = 5;
        for (int i = 0; i < 5; i++) {
            count--;
            System.out.println(Thread.currentThread().getName() + " - " + count);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        // 测试对象锁
        SynchronizedTest synchronizedTest = new SynchronizedTest();

        /*Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedTest.test1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedTest.test1();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedTest.test5();
            }
        });
        t1.start();
        t2.start();
        t3.start();*/


        // 测试类锁
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedTest.test3();
            }
        });
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedTest.test3();
            }
        });
        Thread t6 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedTest.test5();
            }
        });
        t4.start();
        t5.start();
        t6.start();
    }

}
