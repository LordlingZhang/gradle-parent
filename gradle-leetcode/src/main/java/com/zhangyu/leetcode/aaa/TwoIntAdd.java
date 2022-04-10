package com.zhangyu.leetcode.aaa;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @description:1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * @author: ZhangYu
 * @date: 2022/4/10
 */
@Slf4j
public class TwoIntAdd {
    /**
     * 利用找 target -x
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        // 哈希表解决，变O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length; i++) {
            int ss = target - nums[i];
            if (map.containsKey(ss)) {
                return new int[]{map.get(ss), i};
            }
            map.put(nums[i], i);
        }
//        for (int i = 0 ; i < nums.length - 1; i++) {
//            int ss = target - nums[i];
//            int idx = findNumIdx(nums, ss, i);
//            if (idx != -1 && idx != i) {
//                return new int[]{i, idx};
//            }
//        }
        return new int[]{-1, -1};
    }

    public static int findNumIdx(int[] nums, int n, int currIdx) {
        for (int i = currIdx + 1 ; i < nums.length; i++) {
            if (nums[i] == n) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
//        int[] nums = new int[]{2,7,11,15};
        log.info("输出：{}", twoSum(nums, 6));
    }
}
