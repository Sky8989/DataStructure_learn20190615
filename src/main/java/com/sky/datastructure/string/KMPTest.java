package com.sky.datastructure.string;

import java.util.Arrays;

public class KMPTest {

    public static void main(String[] args) {

        /**
         * "mississippi"
         * "issip"
         */

//        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str1 = "mississippi";
        String str2 = "issip";

       int[] arr =  kmpNext(str2);
        System.out.println(str2);
        System.out.println(Arrays.toString(arr));

        System.out.println(kmpSearch(str1,str2));
    }

    public static int kmpSearch(String src,String sub){

        if(!src.isEmpty()){

            // sub串 下标数组
            int[] next = kmpNext(sub);

            for(int i =0, j  = 0; i < src.length(); i++){

                // 子串 不匹配时,  使用next数组去掉多余判断
                while (j > 0 && src.charAt(i) != sub.charAt(j)){
                    j = next[j - 1];
                }

                //子串匹配时,  移动 next数组的下标(寻找最大匹配词)
                if(src.charAt(i) == sub.charAt(j)){
                    j++;
                }


                //结束条件   next数组全部匹配 说明 sub 全部匹配上 src的子串
                if(j == next.length){
                    //i src 包含 sub 最后一位的位置, j 为sub的长度   i-j = 减去sub后 前面不匹配字符串的最后一个位置
                    // +1 为 sub 匹配上 src 子串的 第一个位置
                    return i - j + 1;
                }
            }
        }

        return -1;
    }


    public  static int[]  kmpNext(String str){

        int[] next = null;

        if(!str.isEmpty()){
            next = new int[str.length()];
            // 首字母的匹配字符数 默认为0
            next[0] = 0;

            char[] charArray = str.toCharArray();
            //因为首字母的匹配字符数 默认为0, 所有从 1开始进行循环匹配
            for(int i = 1, j = 0; i < charArray.length; i++){


                while (j >  0 && charArray[i] != charArray[j]){ //不相等 该移动到哪里
                    j = next[j-1];
                }

                if(charArray[i] == charArray[j]){ //相等 匹配字符数+1
                    j++;
                }


                next[i] = j;

            }

        }

        return next;

    }
}
