package com.sky.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 示例 1:

 输入: 123
 输出: 321
  示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-integer
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 整数反转
 */
public class TestReverse {

    /**
     * 整数反转，
     * 通过转字符串进行反转
     *
     *
     * @param x
     * @return
     */
    public int reverse(int x) {

        if(x == 0 ) return 0;

        //标识正负
        boolean flag = true;
        if(x < 0){
            flag = false;
        }

        char[] chars = Integer.toString(x).toCharArray();
        //System.out.println("反转前=" + Arrays.toString(chars));

        //双指针 进行反转,x为负数，chars第一个数不进行交换
        for(int i = flag ? 0:1, j = chars.length - 1; i < j ; i++,j--){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

       // System.out.println("反转后=" + Arrays.toString(chars));

       Long resultNum =  Long.parseLong( new String(chars));
       //注意位置
       if( Math.pow(-2,31) > resultNum || resultNum > (Math.pow(2,31) - 1)) return 0;

       return resultNum.intValue();

    }

    /**
     * 通过数学法 进行反转
     * @param x
     * @return
     */
    public int reverse1(int x){
        Long res = 0L;
        while (x != 0){
            //取个位 反转 每次乘以10 进行反转
            res = res * 10 + ( x % 10);
            //去除个位 后的数赋值给x
            x /= 10;
        }
        if( Math.pow(-2,31) > res || res > (Math.pow(2,31) - 1)) return 0;
        return res.intValue();
    }

    /**
     * 数学法
     * 在循环中进行值区域判断
     * @param x
     * @return
     * 时间复杂度：O(log(x)) x中大约有 log10(x) 位数字
     */
    public int reverse2(int x){
        int rev = 0;
        while (x != 0) {
            //取个位
            int pop = x % 10;
            x /= 10;
            /**
             * 溢出判断
             * rev > Integer.MAX_VALUE/10 大于int的最大值
             * rev < Integer.MIN_VALUE/10 小于int的最小值
             * (rev == Integer.MAX_VALUE / 10 && pop > 7) 最大值的最后一位为7
             * (rev == Integer.MIN_VALUE / 10 && pop < -8) 最小值的最后一位为8
             */
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/ 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;


    }

    @Test
    public void reverseTest(){
//        System.out.println( reverse(1534236469));
        System.out.println( reverse2(-123));
    }

}
