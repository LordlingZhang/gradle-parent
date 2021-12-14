package com.zhangyu.nowcoder;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author zhangyu
 * @description: NC93 设计LRU缓存结构
 * https://www.nowcoder.com/practice/e3769a5f49894d49b871c09cadd13a61?tpId=117&tqId=37851&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking
 * 设计LRU(最近最少使用)缓存结构，该结构在构造时确定大小，假设大小为 k ，并有如下两个功能
 * 1. set(key, value)：将记录(key, value)插入该结构
 * 2. get(key)：返回key对应的value值
 * @date 2021/12/1
 */
@Slf4j
public class NC93LRU {

    public static void main(String[] args) {
//        int[][] opers = {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int[][] opers = {{1,1,1},{1,2,2},{2,1},{1,3,3},{2,2},{1,4,4},{2,1},{2,3},{2,4}};
        log.info("output:{}", LRU(opers, 2));
    }

    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public static int[] LRU (int[][] operators, int k) {
        // write code here
        // 定义存储集合，int[2]  第一位key，第二位value
        List<Integer> output = new ArrayList<>();
        List<int[]> storeList = new ArrayList<>();
        for (int[] oper : operators) {
            // set操作
            if (oper[0] == 1) {
                setProcess(oper, storeList, k);
            }
            // get操作
            else if (oper[0] == 2) {
                output.add(getProcess(oper, storeList));
            }
        }
        return output.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * set方法
     * @param setArr
     * @param storeList
     * @param k
     */
    public static void setProcess(int[] setArr, List<int[]> storeList, int k) {
        // 不存在
        int index = exists(storeList, setArr[1]);
        if (index == -1) {
            // 存储已满,去掉最早的
            if (storeList.size() == k) {
                storeList.remove(0);
            }
            storeList.add(new int[]{setArr[1], setArr[2]});
            return;
        }
        // 存在,需要换位置
        storeList.remove(index);
        storeList.add(new int[]{setArr[1], setArr[2]});
    }
    /**
     * get方法
     * @param getArr
     * @param storeList
     */
    public static int getProcess(int[] getArr, List<int[]> storeList) {
        // 不存在
        int index = exists(storeList, getArr[1]);
        if (index == -1) {
            return -1;
        }
        // 存在,需要换位置
        int val = storeList.get(index)[1];
        storeList.remove(index);
        storeList.add(new int[]{getArr[1], val});
        return val;
    }

    /**
     * 判断是否存在
     * @param storeList
     * @param key
     * @return 存在->位置，不存在-> -1
     */
    public static int exists(List<int[]> storeList, int key) {
        for (int[] a : storeList) {
            if (a[0] == key) {
                return storeList.indexOf(a);
            }
        }
        return -1;
    }

}
