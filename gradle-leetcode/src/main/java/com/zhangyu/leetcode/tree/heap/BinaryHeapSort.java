package com.zhangyu.leetcode.tree.heap;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author zhangyu
 * @description: 二叉堆 排序
 * @date 2021/5/20
 */
@Slf4j
public class BinaryHeapSort {

    public static void main(String[] args) {
        // 构建堆
        int[] arr = {1,3,2,6,5,7,8,9,19,0};
        log.info("构建前:{}", Arrays.toString(arr));
        // 排序
        sort(arr);
        log.info("排序后:{}", Arrays.toString(arr));
    }

    /**
     * 排序
     * @param arr
     */
    public static void sort(int[] arr) {
        // 1、通过下沉操作 构建最小堆
        BinaryHeapOperate.buildHeap(arr);
        log.info("构建后:{}", Arrays.toString(arr));
        // 2、循环删除堆顶数据，放到尾部，通过下沉调整为新的堆顶
        for (int i = arr.length - 1;i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // 下沉
            BinaryHeapOperate.down(arr, 0, i);
        }
    }
}
