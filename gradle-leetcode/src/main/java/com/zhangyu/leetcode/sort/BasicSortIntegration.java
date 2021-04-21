package com.zhangyu.leetcode.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @description: 基礎排序整合
 * @author: zhangyu
 * @date: 2021/4/20
 */
@Slf4j
public class BasicSortIntegration {
    public static void main(String[] args) {
        int[] arr = {3,231,512,522,5,1,4,35,0};
        insertionSort(arr, arr.length);
    }
    /**
     * 【插入排序】
     *  分左右两块区域，左边是有序，右边无序
     */
    public static void insertionSort(int[] arr, int n) {
        log.info("排序前：{}", arr);

        // 从第2个开始遍历
        for (int i = 1; i < n; i++) {
            // val 待插入的位置
            // 记录待排序字段val
            int val = arr[i];
            int x = i;
            for (int j = i - 1; j >= 0; j --) {
                if (arr[j] > val) {
                    // 当前元素往后移1位
                    arr[j + 1] = arr[j];
                    x = j;
                } else {
                    // 结束循环
                    break;
                }
            }
            // 一轮结束，插入val
            arr[x] = val;
        }
        log.info("排序后：{}", arr);
    }
}
