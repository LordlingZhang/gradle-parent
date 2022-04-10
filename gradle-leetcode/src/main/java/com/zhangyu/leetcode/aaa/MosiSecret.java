package com.zhangyu.leetcode.aaa;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 804. 唯一摩尔斯密码词
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 *  * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","..
 *  * .","-","..-","...-",".--","-..-","-.--","--.."]
 *
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 *
 * @author: ZhangYu
 * @date: 2022/4/10
 */
public class MosiSecret {

    public static int getMosiSize(String[] words) {
        String[] mosiT = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                // 获取对应的摩斯码
                sb.append(mosiT[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(getMosiSize(words));
    }

}
