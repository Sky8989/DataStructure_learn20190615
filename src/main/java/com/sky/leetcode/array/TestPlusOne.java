package com.sky.leetcode.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。
 示例 2:

 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/plus-one
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestPlusOne {

    /**
     * 注意 进位判断，考虑到数组扩容
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int[] res = null;

        if(digits == null || digits.length == 0 ) return new int[]{};

        int end = digits.length - 1;
        while (end >= 0){
            int sum = digits[end] +  1;

            //进位
            if(sum >= 10){
                int ge = sum % 10;
                digits[end] = ge;
                end--;
                //进行扩容
                if(end < 0){
                    res = new int[digits.length+1];
                    res[0] = 1;

                }
            }else{
                digits[end] = sum;
                res = digits;
                break;
            }
        }
        return res;
    }

    @Test
    public void testPlusOne(){
//        int[] arr = new int[]{1,2,3};
//        int[] arr = new int[]{4,3,2,1};
//        int[] arr = new int[]{4,3,2,9};
        int[] arr = new int[]{9,9,9,9};

        System.out.println(Arrays.toString(plusOne(arr)));
    }
}
