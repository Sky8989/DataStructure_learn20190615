package com.sky.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 希尔排序是希尔（Donald Shell）于1959年提出的一种排序算法。希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序。
 *
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
 */
public class ShellSort {


    @Test
    public void test2(){

        int[] arr = {8,9,1,7,2,3,5,4,6,0};

        testShellSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public void testShellSort(int[] arr){

        int len = arr.length;

        int gap = len/2;


        while (gap >  0){

            //外循环
           for(int i = gap; i < len; i++){
               int temp = arr[i];

               int j = i - gap;
               for(; j >= 0 && temp < arr[j]; ){
                   arr[j + gap ] = arr[i];
                  j -= gap;
               }
               arr[j + gap] =  temp;

           }
           gap /= 2;

        }

    }
}
