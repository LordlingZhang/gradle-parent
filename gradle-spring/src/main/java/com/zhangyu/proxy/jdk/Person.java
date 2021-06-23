package com.zhangyu.proxy.jdk;

public interface Person {

    /**
     * find
     */
    void findLove();

//    void play();

    default void aa(){
        System.out.println("q423");
    }

    default void bb(){
        System.out.println(1234567);
    }
}
