package com.zhangyu.leetcode.aaa;

/**
 * @description: 旋转字符串
 * 示例 1:
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * 示例 2:
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 * 链接：https://leetcode-cn.com/problems/rotate-string
 * @author: ZhangYu
 * @date: 2022/4/7
 */
public class RotateString {

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        // 利用s + s 是否包含goal
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {
        String s = "12345";
        String goal = "34512";
        System.out.println(rotateString(s, goal));
    }

}
