package com.sky.test;

import org.junit.Test;

public class TowSearchTest {

    @Test
    public void searchTest(){
        int[] arr = new int[]{1,3,5,6};
        int i = 2;

        System.out.println(searchInsert(arr,i));
    }

    /**
     * 二分法 查询 找到 target的插入位置 注意nums数组中的数字不重复
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {

        if(nums == null || nums.length <= 0){
            return 0;
        }

        int min = 0;
        int max = nums.length-1;


        while(min <= max){

            int index = min + (max - min) / 2;


            if(nums[index] > target){
                // 大于 中间值 最大值 = 中间值下标往前移动一位
                max = index-1;

            }else if(nums[index] < target){
                // 小于 中间值 最小值 = 中间值下标往后移动一位
                min = index+1;

            }else{
                //相等直接 返回下标
                return index;
            }
        }

        return min;

    }
}
