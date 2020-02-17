package com.sky.leetcode.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/two-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestTwoSum {

    @Test
    public void testArraySum(){

        int[] arr = new int[]{2,7,11,15};
        int target = 9;
//        int[] resArr  = twoSum(arr,target);
        int[] resArr  = twoSum1(arr,target);
        System.out.println(Arrays.toString(resArr));
    }

    /**
     * 两遍 哈希
     * @param nums
     * @param target
     * @return
     */
    public int[] towSum2(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }

        for(int j = 0; j < nums.length; j++){
            int num = target - nums[j];
            if(map.containsKey(num) && map.get(num) != j){
                return new int[]{j,map.get(num)};
            }
        }

        return null;
    }

    /**
     * 利用哈希表 一遍哈希
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
          Integer r1 =  map.get(target - nums[i]);

          if(r1 == null){
              map.put(nums[i],i);
          }else{
              return new int[]{r1,i};
          }
        }

        return null;
    }

    /**
     * 暴力法 双重循环
     */
    public int[] twoSum1(int[] nums, int target){

        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length-1; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
