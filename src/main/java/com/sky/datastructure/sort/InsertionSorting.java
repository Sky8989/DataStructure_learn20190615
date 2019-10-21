package com.sky.datastructure.sort;

/**
 * 插入排序
 * 插入排序（Insertion Sorting）的基本思想是
 * ：把n个待排序的元素看成为一个有序表和一个无序表，
 * 开始时有序表中只包含一个元素，
 * 无序表中包含有n-1个元素，
 * 排序过程中每次从无序表中取出第一个元素，
 * 把它的排序码依次与有序表元素的排序码进行比较，
 * 将它插入到有序表中的适当位置，使之成为新的有序表。
 */
public class InsertionSorting {

    public static void main(String[] args) {
        int[] arr =  {2, 1, 7, 9, 5, 8};
    }


    public void insertSort(int[] arr){

        for(int i = 1; i < arr.length - 1; i++){
         for(int j = i-1; j < arr.length ; j++){
             if(arr[i] >= arr[j]){
                 int temp = arr[i];
                 arr[i] = arr[j];
                 arr[j] = temp;
                 break;
             }
         }
        }

    }
}
