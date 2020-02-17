package com.sky.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

 必须原地修改，只允许使用额外常数空间。

 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/next-permutation
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestNextPermutation {

     @Test
     public void testArray(){
         int[] arr = new int[]{1,2};
//         int[] arr = new int[]{1,2,3,1};
//         int[] arr = new int[]{1,3,2};
//         int[] arr = new int[]{3,2,1,1};
         nextPermutation(arr);
     }

/**    倒序查找
*    1：通过倒序查找出 一个顺序状态下的index 比如 arr={1,3,2}
*    第一个顺序的起点 arr[i] = 1 <= arr[i+1]  = 3  i = 0
*    2: i > 0 进行比较 j = length-1 j也是逆序查找，
*    从 length-1 进行比较  arr[j] = 2 > nums[i] = 3 时 i=0 和 j=1 进行交换,最后从i+1开始倒序
*    2.1： 然后在 i+1 的下标起点开始倒序
 *    3： i < 0 说明数组全部为倒序状态 从i+1 = 0 为起点开始倒序
**/
    public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            /**
             * 找倒序的起点的前一个下标 [1,3,2] index[0] = 1 所以i的右边都是有序倒序
             * 如果完全符合这个情况 数组有序 倒序的话，最终 i = -1
             * 用 i 来确定需要反转的下标
             *
             */
            while (i >= 0 && nums[i + 1] <= nums[i]) {
                i--;
            }
            //不是完全倒序
            if (i >= 0) {
                int j = nums.length - 1;
                //从最后一个数开始找倒叙的起点  [1,3,2] 倒序的起点的下标 index[1]=3
                while (j >= 0 && nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }


            reverse(nums, i + 1);

            System.out.println(Arrays.toString(nums));
        }

    /**
     * 反转
     *
     * @param nums
     * @param start 开始反转的下标
     */
    private void reverse(int[] nums, int start) {
            int i = start, j = nums.length - 1;
            //双指针法 进行反转
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        //两个数字 进行交换
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }



}
