package com.zhangyu.thread;

/**
 * @author zhangyu
 * @description 中断
 * @date 2020/4/3
 */
public class MyThreadInterrupt {

    public static void main(String[] args) {
        System.out.println("begin");
        Thread.currentThread().interrupt();
        // 第一次会清除中断状态标识
        System.out.println("是否中断？" + Thread.interrupted());
        // 第二次还是未中断
        System.out.println("是否中断？" + Thread.interrupted());

       /* // isInterrupted() 不会清除标识
        System.out.println("是否中断1？" + Thread.currentThread().isInterrupted());
        System.out.println("是否中断1？" + Thread.currentThread().isInterrupted());
*/

        System.out.println("end");
    }

    /**
     * 先interrupt再sleep，或者交换顺，都是会抛出interruptException的
     */
    static class ThreadInterrupt extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                for (int i = 0; i < 50000; i ++){
                    if (this.isInterrupted()){
                        System.out.println("线程终止咯");
                        // 完全终止最好抛异常，否则for循环还是会继续
                        throw new InterruptedException();
                    }
                    System.out.println("i:" + i);
                }
            } catch (InterruptedException e) {
                System.out.println("end-interrupt");
            }
        }

    }
}
