package com.zhangyu.thread;

/**
 * @author zhangyu
 * @description thread stop
 * @date 2020/4/10
 */
public class MyThreadStop extends Thread{

    private int i = 0;

    @Override
    public void run() {
        try {
            while (true){
                i++;
                System.out.println("i= " + i);
                Thread.sleep(1000);
            }
        }catch (ThreadDeath e){
            // 執行stop方法会抛出该异常，但是不需要去显式的捕捉
            System.out.println("eeeee");
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            MyThreadStop myThreadStop = new MyThreadStop();
            myThreadStop.start();
            Thread.sleep(8000);
            // 方法已经被弃用，可能导致一些请理性工作无法完成
            myThreadStop.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
