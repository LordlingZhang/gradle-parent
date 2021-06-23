package com.zhangyu.leetcode.array;

/**
 * @author zhangyu
 * @description: 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * Input:
 * {2, 3, 1, 0, 2, 5}
 * Output:
 * 2
 *
 * https://github.com/CyC20 18/CS-Notes/blob/master/notes/3.%20%E6%95%B0%E7%BB%84%E4%B8%AD%E9%87%8D%E5%A4%8D%E7%9A%84%E6%95%B0%E5%AD%97.md
 * @date 2021/6/23
 */
public class SameCharInArray {

    public static void main(String[] args) {
        int[] arr = {4,3,1,0,2,5};
        System.out.println(findNumber(arr));
    }

    /**
     * 本题的解题思路： 把每个元素按 值大小放到 index=val的位置
     * @param arr
     * @return
     */
    public static int findNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                // 找到arr[i]应该在的位置，如果这个位置的值和arr[i]相同，那直接返回
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                }
                swap(arr, i, arr[i]);
            }
        }
        return -1;
    }

    /**
     * 交换位置
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
