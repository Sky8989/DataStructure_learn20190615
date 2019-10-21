package com.sky.test;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class TestRemoveDuplicates {


    /**
     *
     * 双指针法
     *
     * 示例 1:
     * 给定数组 nums = [1,1,2],
     *
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 2:
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums){
        if(nums == null || nums.length == 0 ){
            return 0;
        }

        //慢指针 存储实际去重后的数据中的元素个数
        int i = 0;

        //j 快指针
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){ //当来指针对应的值 不想等时
                i++; //记录个数
                nums[i] = nums[j];  //赋值

            }
        }

        return i+1;

    }

    public int removeDuplicates1(int[] nums){
        if(nums == null || nums.length == 0 ){
            return 0;
        }

        //慢指针 存储实际去重后的数据中的元素个数
        int i = 0;

        //j 快指针
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){ //当来指针对应的值 不想等时

                nums[++i] = nums[j];  //赋值


            }
        }

        return i+1;

    }

    @Test
    public void  TestArray(){
        int[] nums = new int[]{1,1,2};
        System.out.println(" nums = " + Arrays.toString(nums));
        System.out.println(removeDuplicates1(nums));
    }
}
