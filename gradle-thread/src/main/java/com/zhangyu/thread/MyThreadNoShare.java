package com.zhangyu.thread;

/**
 * @author zhangyu
 * @description 线程不共享
 * @date 2020/3/30
 */
public class MyThreadNoShare extends Thread{

    private int count = 5;


    public MyThreadNoShare(String name) {
        this.setName(name);
    }

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see Thread(ThreadGroup, Runnable, String)
     */
    @Override
    public void run() {
        while (count > 0){
            System.out.println(this.getName() + ": " + count );
            count --;
        }
    }
}
