package com.sky.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 解码问题
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 */
public class TestNumDecodings {

    /**
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
     *
     * 示例 1:
     * 输入: "12"
     * 输出: 2
     * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
     *
     * 示例 2:
     * 输入: "226"
     * 输出: 3
     * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if(s.isEmpty()){
            return 0;
        }

        Map<Integer,String> map = new HashMap<>();
        Integer num = Integer.parseInt(s);


        if(num > 26){

        }else{

        }



        return 0;
    }
}
