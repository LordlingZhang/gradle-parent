package com.zhangyu.leetcode.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangyu
 * @description: 快速排序的实现
 * @date 2021/11/30
 */
@Slf4j
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] {2,4,2,8,1,3,9,0,1};
        log.info("排序前:{}", arr);
        sort(arr, 0, arr.length - 1);
        log.info("排序后:{}", arr);
    }

    public static void sort(int[] arr, int startIdx, int endIdx){
        if (startIdx >= endIdx) {
            return;
        }
        // 获取基准位置
//        int p = getJizhunPointDouble(arr, startIdx, endIdx);
        int p = getJizhunPointSingle(arr, startIdx, endIdx);
        // 左右两边开始递归
        sort(arr, startIdx, p - 1);
        sort(arr, p + 1, endIdx);
    }

    /**
     * 获取基准位置 （双边循环法）
     * 分治
     * @param arr
     * @param startIdx
     * @param endIdx
     * @return
     */
    public static int getJizhunPointDouble(int[] arr, int startIdx, int endIdx) {
        // 取第一个当做基准点
        int jzp = arr[startIdx];
        int left = startIdx, right = endIdx;
        // 外层循环
        while (left != right) {
            // right在zjp的右边，则继续往后遍历(注：先右后左)
            while (left < right && arr[right] > jzp) {
                right --;
            }
            // left在zjp的左边，则继续往后遍历
            while (left < right && arr[left] <= jzp) {
                left ++;
            }
            // 交换左右两边不符合的的位置数据
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // 次轮遍历结束，得到新的基准位置，就是left或者right
        arr[startIdx] = arr[left];
        arr[left] = jzp;
        return left;
    }
    /**
     * 获取基准位置 （单边循环法）
     * 本质就是 计算比基准小的个数，然后得到基准的位置
     * 分治
     * @param arr
     * @param startIdx
     * @param endIdx
     * @return
     */
    public static int getJizhunPointSingle(int[] arr, int startIdx, int endIdx) {
        // 取第一个当做基准点
        int jzp = arr[startIdx];
        int mark = startIdx; // 标记边界位置

        for(int i = startIdx + 1; i <= endIdx; i++) {
            if (arr[i] < jzp) {
                // 边界右移1位，并且该值放到边界左侧
                mark ++;
                int t = arr[mark];
                arr[mark] = arr[i];
                arr[i] = t;
            }
        }

        arr[startIdx] = arr[mark];
        arr[mark] = jzp;
        return mark;
    }



}
