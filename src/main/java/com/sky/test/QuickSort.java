package com.sky.test;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 快速排序（Quicksort）是对冒泡排序的一种改进。
 基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，
 其中一部分的所有数据都比另外一部分的所有数据都要小，
 然后再按此方法对这两部分数据分别进行快速排序，
    整个排序过程可以递归进行，以此达到整个数据变成有序序列
 */
public class QuickSort {

    @Test
    public void testQuickSort(){
        int[] arr =  {2, 1, 7, 9, 5, 8};
        quickSortTest(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public void quickSortTest(int[] arr,int left,int right){

        //基准点
        int pivot = arr[left+right/2];
        int temp = 0;
       while(left  < right){
           if(arr[left] < pivot){
               left += 1;
           }

           if(arr[right] > pivot){
               right -= 1;
           }

           if(left > right){
               break;
           }

           if(arr[left] > pivot || arr[right] < pivot){
               temp = arr[left];
               arr[left] = arr[right];
               arr[right] = temp;
           }

           if(arr[left] == pivot){
               right -= 1;

           }

           if(arr[right] == pivot){
               left += 1;
           }

           if(right == left){
               left += 1;
               right -= 1;
           }


           if(left < right){
               quickSortTest(arr,left,right);
           }

           if(right > left){
               quickSortTest(arr,left,right);
           }
       }




    }
}
