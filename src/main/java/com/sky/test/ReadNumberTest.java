package com.sky.test;

import java.util.HashMap;
import java.util.Map;

public class ReadNumberTest {

    public static void main(String[] args) {
        String str = countAndSay(3);

        System.out.println(str);
    }

    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();

        int length = n;

        //计算连续相同数的总个数
        int count = 0;
        //数字
        int number = 0;



        for(int i = 1; i <= length; i++){

           if(number != i){
               number = i;
             //  while (count-- > 0)

               sb.append(number*3);
               sb.append(number);

           }else{
               count++;
           }


        }



        return  sb.toString();


    }
}
