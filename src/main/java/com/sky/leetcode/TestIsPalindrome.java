package com.sky.leetcode;

import org.junit.Test;

/**
 * 9. 回文数
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

 示例 1:

 输入: 121
 输出: true
 示例 2:

 输入: -121
 输出: false
 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 示例 3:

 输入: 10
 输出: false
 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 进阶:

 你能不将整数转为字符串来解决这个问题吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/palindrome-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestIsPalindrome {

    /**
     * 判断是否为回文数
     * 对比一半，每次比较一个数
     * @param x
     * @return
     * 时间复杂度O(log10(n))
     */
    public boolean isPalindrome(int x) {
        //边界判断
        if (x < 0) return false;
        //div用来获取当前数的最左一个数
        int div = 1;
        // 保证 div的 位数和 x一直 比如 x=123  div=100  123/100=1
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            //获取当前 x 最左一个数
            int left = x / div;
            //获取当前 x 最右一个数
            int right = x % 10;
            //不是回文数
            if (left != right) return false;
            //(x%div)去除最左一个数   /10 去除最右一个数  如：123  123%100 = 23   23/10 = 2
            x = (x % div) / 10;
            //div 因为x 去除一个最左最右两个数 位数下降百位 所以 div为保存和x同等位数所有除100
            div /= 100;
        }
        return true;
    }

    /**
     * 通过反转数字 将反转前后两个数进行对比
     * 缺点： 运行时间长， 反转后的数字有可能溢出
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        //边界判断
        if (x < 0) return false;

        long x1 = x;
        //防止溢出
        long result = 0;
        while (x > 0) {

            result = result * 10 + (x % 10);
            //速度慢
//            result *= 10;
//            result += x % 10;
            x /= 10;

        }
       return x1 == result ? true : false;
    }

    @Test
    public void testRe(){
        System.out.println( isPalindrome3(20200202));
    }

    /**
     * 回文数判断 数学法
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x){

        if(x < 0) return false;

        // div 除数
        int div = 1;

        //相同位数 x 和 div
        while (x / div >= 10) div *= 10;

        while (x > 0){

            int left = x / div;
            int right = x % 10;
            //x 的最大位数的值 和 个位数的值对比  判断回文
            if(left != right) return false;
            //去除最左一个数，
            x %= div;
            //去除最右一个数
            x /= 10;
            // 位数和x保持一致
            div /= 100;
        }

        return true;

    }


    /**
     * 巧妙反转一半 比较法
     * @param x
     * @return
     */
    public boolean isPalindrome3(int x ){ // x = 121

        //由题意知道 负数和个位为0的数不可能为 回文数
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;

        //反转一半的数字
        int resultNumber = 0;

        //当 x 大于 resultNumber 反转一半
        while (x > resultNumber){ // 121 > 0 -> 12 > 1 ->  2 < 12
            resultNumber = resultNumber *  10 + (x % 10);  //   1  ->  12
            x /= 10;  // 12 -> 2
        }
        // x == resultNumber 当x为两位数时的比较方法    x = 2  resultNumber = 12
        return  x == resultNumber || x == resultNumber / 10;

    }

}
