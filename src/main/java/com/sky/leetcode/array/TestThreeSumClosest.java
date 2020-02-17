package com.sky.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。

 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/3sum-closest
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestThreeSumClosest {

    /**
     * 双指针法
     * 注意点
     * 1：让数组有序
     * 2： 多个变量时，先确定一个变量， 然后确定一个最小点  一个最大点
     * 3： 找到一个相应的值 进行对比大小   大于（最大点往下移动）  小于(最小值往上移动)
     * 4： 然后进行对比的操作或者赋值等。
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {

        //1:判断 界限
      //  if(nums == null || nums.length < 3) return 0;

        //2:排序
        Arrays.sort(nums);

        //比较的差值
        int resc  = Integer.MAX_VALUE;
        //差值 对应的数
        int resNum  = 0;

        for(int k = 0; k < nums.length - 2; k++){
            //初始化指针
            int i = k + 1,j = nums.length - 1;
            //循环指针进行计算


            while (i < j){

                int sum = (nums[k] + nums[i] + nums[j]);
                // 三个数 与 目标值的绝对差值
                int diff = Math.abs(sum  - target);

                System.out.println("diff = " + diff);

                //3：循环进行比较 确定指针的 移动方向
                if(sum == target){
                    return target;
                }else  if(sum > target){
                    j--;
                }else if(sum < target){
                    i++;
                }

                // 4：对比绝对差值越小 赋值给 返回结果
                if(resc > diff){
                    resc = diff;
                    resNum = sum;
                }

            }
        }

        return resNum;
    }

    /**
     * 双指针 细节优化版本
     * 减少 定义过多成员变量
     */
    public int threeSumClosestPro(int[] nums, int target){

        //初始化 正负数，溢出等
        int resNum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int k = 0; k < nums.length - 2; k++){

            int i = k + 1, j = nums.length - 1;

            while (i < j){
                int sum = nums[k] + nums[i] + nums[j];

                if(sum == target){
                    return target;
                }else if(sum > target){
                    j--;
                }else {
                    i++;
                }

                //判断差值大小进行赋值
                if(Math.abs(resNum - target) > Math.abs(sum - target)){
                    resNum = sum;
                }

            }
        }
        return resNum;
    }


    /**
     * 暴力法
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest1(int[] nums, int target){

        int resNum = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            for (int j = i+1; j < nums.length - 1; j++){
                for(int k = j+1; k < nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];

                    if(sum == target){
                        return target;
                    }else{
                        //比较差值大小
                        if(Math.abs(resNum -  target) > Math.abs(sum - target)){
                            resNum = sum;
                        }
                    }

                }
            }
        }
        return resNum;
    }

    @Test
    public void testSum(){
        int[] arr = new int[]{-1,2,1,-4};
//        int[]  nums = new int[]{-2,0,0,2,2};
        int[]  nums = new int[]{-3,-2,-5,3,-4};

        System.out.println(threeSumClosestPro(arr,1));
        System.out.println(threeSumClosestPro(nums,-1));

    }
}
