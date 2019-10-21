package com.sky.datastructure.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 选择排序（select sorting）也是一种简单的排序方法。
 * 它的基本思想是：第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换，
 * 第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换，
 * 第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换，…，
 * 第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换，…,
 * 第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换，
 * 总共通过n-1次，得到一个按排序码从小到大排列的有序序列。
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {8,3,2,1,7,4,6,5};
        selectSortTest(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSortTest(int[] arr){


        int val = 0;
        int index = 0;
        for(int i = 0; i < arr.length-1; i++){
            //初始化
            val = arr[i];
            index = i;

            for(int j = i + 1; j < arr.length; j++){
                //对比大小 找最小值
                if(val > arr[j]){
                    val = arr[j]; //最小值
                    index = j; //最小值下标
                }
            }

            //下标不一致 进行交换位置
            if(index != i){
                int temp = arr[i] ;
                arr[i] = val;
                arr[index] = temp;


            }
        }

    }
}
