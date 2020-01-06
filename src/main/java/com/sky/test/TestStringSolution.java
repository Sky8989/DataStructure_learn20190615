package com.sky.test;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;

public class TestStringSolution {



    @Test
    public void TestFirstChar(){

        String s = "loveleetcode";


        int index = firstUniqCharOneFor(s);

        System.out.println(index);
    }

    /**
     * 一次循环遍历
     */
    public int firstUniqCharOneFor(String s){
        if(s.isEmpty()){
            return -1;
        }else {
            int first = 0;
            for(int i = 0; i < s.length(); i++){

                first =  s.indexOf(s.charAt(i));

              //下标相等 在同一个位置只有一个
              if(first == s.lastIndexOf(s.charAt(i)) ){
                  return first;
              }else{
                  continue;
              }
            }
        }
        return -1;
    }

    public int firstUniqCharArray(String s) {

        if(s.isEmpty()){
            return  -1;
        }else{
            //将 字符转成数字 对应数组下标
            int[] intArr = new int[26];
            //字符串 转字符数组
            char[] arr = s.toCharArray();

            for(int i = 0; i < arr.length; i++){
                intArr[(arr[i] - 'a')] += 1;
            }

            for(int i = 0; i < s.length(); i++){
                if(intArr[arr[i] - 'a'] == 1){
                    return i;
                }
            }

            return -1;
        }
    }

    public int firstUniqChar(String s) {


        if(s.isEmpty()){
            return  -1;
        }else{
            //记录 字符串 s 中每个字符 出现的个数  key 字符 value出现的个数
            HashMap<Character,Integer>  strMap = new HashMap<>(32);
            //Integer initNum = 1;


            /**
             * 循环遍历 记录每个字符出现的次数
             */
            for(int i = 0; i < s.length(); i++){

//                if(!strMap.containsKey(s.charAt(i))){
//                    strMap.put(s.charAt(i),initNum);
//                }else{
                    strMap.put(s.charAt(i),strMap.get(s.charAt(i)) == null ? 1 : (strMap.get(s.charAt(i))+1) );
//                }
            }

            /**
             * 遍历 s 字符 拿出 第一个不重复的字符 也就是第一个出现字数为1 的字符
             */
            for(int i = 0; i < s.length(); i++){
                if(strMap.get(s.charAt(i)) == 1){
                    return i;
                }
            }
        }

        return  -1;

    }
}
