package com.sky.leetcode.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。
 示例：

 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/3sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestThreeSum {

    /**
     * 双指针法
     * @param nums
     * @return
     *
     * 思路
    标签：数组遍历
    首先对数组进行排序，排序后固定一个数nums[i]，再使用左右指针指向nums[i]最左最右的两端，数字分别为 nums[L] 和nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
    如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
    如果 nums[i] =nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
    当 sum= 0 时，nums[L] = nums[L+1] 则会导致结果重复，应该跳过，L++
    当 sum= 0 时，nums[R] = nums[R−1] 则会导致结果重复，应该跳过，R−−
    时间复杂度：O(n^2)，n 为数组长度
    作者：guanpengchn
    链接：https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length < 3) return list;

        //1：先排序  [-4, -1, -1, 0, 1, 2]
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            //第一个数大于0 后面的都大于0
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue; //去重
            for(int l = i+1,r = nums.length-1; l < r; ){
                int temp = nums[i] + nums[l] + nums[r];
                if(temp == 0){
                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    /**
                     *  循环去重  因为i不变， l和l+1相同，这样 -> i不变 l不变  -> r不变 (i + (l+1) + r = 0)
                     *  所以通过循环进行去重
                     */

                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;

                    /**
                     * 需要放在循环去重后面,因为是以add时的 i，l,r为参考
                     * 每次add后 指针进行移动
                     */
                    l++;
                    r--;
                }else if (temp > 0){
                    r--;
                }else if(temp < 0){
                    l++;
                }
            }
        }
        return list;
    }

    @Test
    public void testThreeSum(){
//        int[]  nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[]  nums = new int[]{1,-1,-1,0};
        int[]  nums = new int[]{-2,0,1,1,2};
//        int[]  nums = new int[]{-2,0,0,2,2};
           List<List<Integer>> resList =  threeSumTest(nums);

       for(List<Integer> list : resList){
           System.out.println(list);
       }
    }

    public List<List<Integer>> threeSumTest(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        //排序
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            //第一个数大于0 后面的数加起来一定大于0
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i+1, r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];

                if(sum == 0){
                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));

                    //通过移动指针跳过重复数字
                    while(l < r && nums[l] == nums[l+1]) l++ ;
                    while(l < r && nums[r] == nums[r-1]) r--;

                    //放在后面移动
                    --r;
                    ++l;

                }else if(sum > 0){
                   --r;
                }else{
                   ++l;

                }
            }
        }

        return list;

    }
}
