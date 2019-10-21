package com.sky.datastructure.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 冒泡排序
 * 冒泡排序(Bubble Sorting)的基本思想是:通过对待排序序列从前向后(从下标较小的元素开始),依次比较
 * 相邻元素的值,若发现逆序则交换,使值较大的元素逐渐从前移向后部,就象水底下的气泡一样逐渐向上冒。
 */
public class BubbleSort {


    public static void main(String[] args) {
        int[] arr = new int[]{3,9,-1,10,20};

        int[] result = bubbleSort(arr,true);
//        int[] result = bubbleSort(arr,false);
        System.out.println("===== " + Arrays.toString(arr));
        System.out.println("===== " + Arrays.toString(result));
    }


    /**
     * 官方冒泡排序
     * @param arr
     * @param ase
     * @return
     */
    public static int[] bubbleSort(int[] arr, boolean ase){

        int[] resultArray = new int[arr.length];
        System.arraycopy(arr,0,resultArray,0,resultArray.length);

        if(ase){
            //顺序
            for(int i = 0; i < resultArray.length-1; i++){
                for(int j = 0; j < resultArray.length-1-i; j++){
                    if(resultArray[j] > resultArray[j+1]){
                        int flag  = resultArray[j];
                        resultArray[j] = resultArray[j+1];
                        resultArray[j+1] = flag;

                    }
                }
            }

        }else {
            //逆序
            for(int i = 0; i < resultArray.length-1; i++){
                for(int j = 0; j < resultArray.length-1-i; j++){
                    if(resultArray[j] < resultArray[j+1]){
                        int temp  = resultArray[j];
                        resultArray[j] = resultArray[j+1];
                        resultArray[j+1] = temp;

                    }
                }
            }

        }


        return resultArray;
    }

    public static int[] bubbleSort1(int[] arr, boolean ase){

        int[] resultArray = new int[arr.length];
        System.arraycopy(arr,0,resultArray,0,resultArray.length);

        if(ase){
            //顺序
            for(int i = 0; i < resultArray.length-1; i++){
                for(int j = i+1; j < resultArray.length; j++){
                    if(resultArray[i] > resultArray[j]){
                        int flag  = resultArray[i];
                        resultArray[i] = resultArray[j];
                        resultArray[j] = flag;

                    }
                }
            }

        }else {
            //逆序
            for(int i = 0; i < resultArray.length-1; i++){
                for(int j = 0; j < resultArray.length-1-i; j++){
                    if(resultArray[j] < resultArray[j+1]){
                        int temp  = resultArray[j];
                        resultArray[j] = resultArray[j+1];
                        resultArray[j+1] = temp;

                    }
                }
            }

        }


        return resultArray;
    }
}
