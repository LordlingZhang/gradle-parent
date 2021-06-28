package com.zhangyu.leetcode.stack;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author zhangyu
 * @description: 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/9.%20%E7%94%A8%E4%B8%A4%E4%B8%AA%E6%A0%88%E5%AE%9E%E7%8E%B0%E9%98%9F%E5%88%97.md
 * @date 2021/6/28
 */
@Slf4j
public class TwoStack2Queue {

    static Stack<Integer> inSt = new Stack<>();
    static Stack<Integer> outSt = new Stack<>();

    /**
     * 推入数据
     * @param d
     * @return
     */
    public static void push(int d) {
        inSt.push(d);
        log.info("inSt:{}", JSON.toJSONString(inSt));
    }
    /**
     * 推出数据
     * @return
     */
    public static int pop() {
        if (outSt != null) {
            // 把 inSt中的数据推到  outSt中，使得顺序翻转
            while (!inSt.isEmpty()) {
                outSt.push(inSt.pop());
            }
        }
        if (outSt == null) {
            return -1;
        }
        int popD = outSt.pop();
        log.info("outSt:{}", JSON.toJSONString(outSt));
        return popD;
    }

    public static void main(String[] args) {
        push(1);
        push(3);
        push(5);
        push(2);
        push(7);
        pop();
    }
}
