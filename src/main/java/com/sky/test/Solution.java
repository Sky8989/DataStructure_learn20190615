package com.sky.test;


import org.junit.Test;

import java.util.*;

/**
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 *
 */
public class Solution {

    public static int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length-1; i++){
            for (int j = i+1; j < nums.length; j++){
                if(target == (nums[i] + nums[j]) ){
                    return new int[]{i,j};
                }
            }
        }

        return null;
    }

    public static int[] twoSum1(int[] nums, int target) {

        /**
         * 通过Map 减少一次循环  key为值 val为索引
         */
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length-1; i++){
                Integer result =  map.get(target-nums[i]);

                if(result == null){
                    map.put(nums[i],i);
                }else {
                    return new int[]{result,i};
                }

        }

        return null;
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{2,3,7,11,15};
//        int target = 9;
//        //arr = twoSum(arr,target);
//        arr = twoSum1(arr,target);
//
//        System.out.println("arr = "+ Arrays.toString(arr));

        int x = 123;
        //        int reuslt = reverse(x);
//        System.out.println("reuslt = "+ reuslt);

//        long y = 0;
//        while (x != 0) {
//            /**
//             *  x % 10 取各位数
//             *  x /= 10 取各位以上的数
//             */
//            y = y * 10 + x % 10;
//            x /= 10;
//        }
//        System.out.println(y);


//        int num = 12321;
////        boolean flag = isPalindrome1(num);
////        if(flag){
////            System.out.println("是一个回文数 :　"+ num);
////        }else{
////            System.out.println(" 不是一个回文数 :　"+ num);
////        }

//        String str = "III";
//        String str = "IV";
//        String str = "IX";
//        String str = "LVIII";
        String str = "MCMXCIV";
       int num =  romanToInt1(str);
        System.out.println("罗马数字 = " + str + " 对应的整数为 = "+ num);


    }


    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *
     *  示例 2:
     * 输入: -123
     * 输出: -321
     *
     * 示例 3:
     * 输入: 120
     * 输出: 21
     */
    public static int reverse(int x) {
        Integer i = new Integer(x);
        int length = i.toString().length();
        String str = i.toString();

        StringBuilder sb = null;
        sb.reverse();

        if(i > 0){
            sb = new StringBuilder();
            for(int j = length-1; j >= 0; j--){
                String restr = str.substring(j,j+1);
                 sb.append(restr);
            }
            return  Integer.parseInt(sb.toString());
        }else if(i == 0){
            return 0;
        }else{
            sb = new StringBuilder();
            //负号
           String fuhao =  str.substring(0,1);
            sb.append(fuhao);

            for(int j = length-1; j > 0; j--){
                String restr = str.substring(j,j+1);
                sb.append(restr);
            }
        }
        return  Integer.parseInt(sb.toString());
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 示例 1:
     * 输入: 121
     * 输出: true
     *
     * 示例 2:
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     *
     * 示例 3:
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        boolean flag = false;
        int num = x;
        int y = 0;

        if(x > 0){
            while(num != 0){
                y = y * 10 + num % 10; // num % 10 取出个位数  y*10将获得的个位 每次放大10倍
                num /= 10; //num /= 10 缩小10倍 减去个位
            }
            if(x == y){
                flag = true;
            }

        }else if(x < 0){
            //负数或者0都不是回文数
        }else{
            //0为回文数
            flag = true;
        }

        return flag;
    }
    public static boolean isPalindrome1(int x) {
        boolean flag = false;
        Integer num = x;
        Long y = 0L;

        if(x > 0){
           StringBuilder sb = new StringBuilder(num.toString());
            sb = sb.reverse();
            y =  Long.parseLong(sb.toString());

          if(y.intValue() == x ){
              flag = true;
          }
        }else if(x < 0){
            //负数或者0都不是回文数
        }else{
            //0为回文数
            flag = true;
        }

        return flag;
    }

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     *     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     *     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     *
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     *
     * 示例 1:
     * 输入: "III"
     * 输出: 3
     *
     * 示例 2:
     * 输入: "IV"
     * 输出: 4
     *
     * 示例 3:
     * 输入: "IX"
     * 输出: 9
     *
     * 示例 4:
     * 输入: "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     *
     * 示例 5:
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int resultNum = 0;

        int len = s.length();
        for(int i = 0; i < len;){
            char ch = s.charAt(i);

            switch(ch){
                case 'I':
                    if(++i < len) {
                        char last = s.charAt(i);

                        if ('V' == last) {
                            i++;
                            resultNum += 4;
                            break;

                        } else if ('X' == last) {
                            i++;
                            resultNum += 9;
                            break;

                        } else {

                        }
                    }

                    resultNum += 1;

                break;

            case 'X':
                if(++i < len) {
                    char last = s.charAt(i);

                    if ('L' == last) {
                        i++;
                        resultNum += 40;
                        break;
                    } else if ('C' == last) {
                        i++;
                        resultNum += 90;
                        break;
                    } else {

                    }

                }

                resultNum += 10;
                break;

                case 'C':
                    if(++i < len) {
                        char last = s.charAt(i);
                        if ('D' == last) {
                            i++;
                            resultNum += 400;
                            break;
                        } else if ('M' == last) {
                            i++;
                            resultNum += 900;
                            break;
                        } else {

                        }
                    }

                    resultNum += 100;
                    break;

                case 'V':
                    resultNum += 5;
                    i++;
                    break;

                case 'L':
                    resultNum += 50;
                    i++;
                    break;
                case 'D':
                    resultNum += 500;
                    i++;
                    break;
                case 'M':
                    resultNum += 1000;
                    i++;
                    break;
            }
        }

        return resultNum;
    }

    /**
     * 使用栈进行处理
     * @param s
     * @return
     */
    public static int romanToInt1(String s) {
        int resultNum = 0;
        int len = s.length();

        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < len;) {
            char ch = s.charAt(i);

            if('I' == ch){
                stack.push(1);
            }else if('V' == ch){

                //存在上一个元素 同时上一个元素为I
                if(!stack.empty()  && 1 == stack.peek()){
                    stack.pop();
                    stack.push(4);
                }else{
                    stack.push(5);
                }
            }else if('X' == ch){

                if(!stack.empty()  && 1 == stack.peek()){
                    stack.pop();
                    stack.push(9);
                }else{
                    stack.push(10);
                }
            }else if('L' == ch){

                if(!stack.empty()  && 10 == stack.peek()){
                    stack.pop();
                    stack.push(40);
                }else{
                    stack.push(50);
                }
            }else if('C' == ch){
                if(!stack.empty()  && 10 == stack.peek()){
                    stack.pop();
                    stack.push(90);
                }else {
                    stack.push(100);
                }
            }else if('D' == ch){
                if(!stack.empty()  && 100 == stack.peek()){
                    stack.pop();
                    stack.push(400);
                }else {
                    stack.push(500);
                }
            }else if('M' == ch){

                if(!stack.empty() && 100 == stack.peek()){
                    stack.pop();
                    stack.push(900);
                }else {
                    stack.push(1000);
                }
            }

            i++;
        }

        len = stack.size();
        for(int i = 0 ; i < len; i++){
            resultNum+= stack.pop();
        }

        return resultNum;
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     *
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String str01 = null;
        StringBuilder sb = new StringBuilder();
        if (strs != null && strs.length > 0) {
            str01 = strs[0];
            if (str01.length() == 0) {
                return "";
            }
            //只有一个字符
            if (strs.length == 1) {
                return str01;

                //多个字符
            }else{
                //字符 下标
                int index = 0;

                while (true) {
                    //标识是否有相同字符
                    boolean flag = false;

                    //那第一个字符串的 单个字符
                    Character c1 = str01.charAt(index);

                    //从第二个字符开始拿字符
                    for (int i = 1; i < strs.length; i++) {

                        //判断是否越界
                        if (strs[i].length() <= index) {
                            flag = false;
                            break;
                        } else {
                            if (c1.toString().equals(strs[i].charAt(index)+"")) {
                                flag = true;
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    }

                    //相同字符 加起来
                    if (flag) {
                        sb.append(c1);
                    } else {
                        break;
                    }

                    //移动下标
                    if (str01.length() > index){
                        index++;
                    }

                    //结束
                    if(str01.length() == index){
                        break;
                    }

                }
            }

        } else {
            return "";
        }
        return sb.length() != 0 ? sb.toString() : "";
    }

    public String longestCommonPrefix1(String[] arrayStr){
        if(arrayStr == null || arrayStr.length == 0){
            return "";
        }

        String prefix = arrayStr[0];
        for(int i = 1; i < arrayStr.length; i++){
            ////循环找 相同字符 从长到短
            while (arrayStr[i].indexOf(prefix) != 0){
                //每次减少 最后一个字符
                prefix = prefix.substring(0,prefix.length()-1);

                //最后没有相同的前缀
                if(prefix.isEmpty()) return "";
            }
        }

        return prefix;

    }


    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     *     左括号必须用相同类型的右括号闭合。
     *     左括号必须以正确的顺序闭合。
     *
     * 注意空字符串可被认为是有效字符串。
     * 示例 1:
     * 输入: "()"
     * 输出: true
     *
     * 示例 2:
     * 输入: "()[]{}"
     * 输出: true
     *
     * 示例 3:
     * 输入: "(]"
     * 输出: false
     *
     * 示例 4:
     * 输入: "([)]"
     * 输出: false
     *
     * 示例 5:
     * 输入: "{[]}"
     * 输出: true

     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s == null ){
            return false;
        }
        if("".equals(s)){
            return true;
        }

        int length = s.length();

        //只有一个字符 或者长度为单
        if( length % 2 > 0){
            return false;
        }
        Map<String,String> map = new HashMap<String, String>();
        map.put("(",")");
        map.put("[","]");
        map.put("{","}");

        Stack<String>  leftStack = new Stack<String>();

        for(int i = 0; i < length; i++){
            String subStr = s.substring(i,i+1);

            //如果为左边括号
            if("(".equals(subStr) || "[".equals(subStr) || "{".equals(subStr)){
                leftStack.push(subStr);
            }else if(")".equals(subStr) || "]".equals(subStr) || "}".equals(subStr)){
                //遇到右括号  取出栈顶字符 然后将取出的右括号去map中找对应右括号 进行对比
                String left = leftStack.pop();
                String right = map.get(left);

                //有效括号
                if(subStr.equals(right)){

                }else{
                    return false;
                }

            }else{
                return false;
            }

        }


        //最后是否栈空
        return leftStack.isEmpty();





    }

    @Test
    public void numberTest(){

//    String str = "()";
    String str = "()[]{}";
//    String str = "(]";
        System.out.println(isValid(str));

    }



    @Test
    public  void tttt(){
//        String[] arr = new String[]{"c","c"};
//        String[] arr = new String[]{"cc","c","c"};
//        String[] arr = new String[]{"flower","flow","flight"};
//        String[] arr = new String[]{"a"};
        String[] arr = new String[]{"abcb","aba","ab"};
//         abcd abc ab
       // String[] arr = new String[]{"dog","racecar","car"};
//        String result = longestCommonPrefix(arr);
        String result = longestCommonPrefix1(arr);
        System.out.println(result);
    }
}
