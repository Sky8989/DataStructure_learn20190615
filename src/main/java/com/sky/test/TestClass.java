package com.sky.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

public class TestClass {

    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>(64);
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");
        map.put(5,"e");
        map.put(6,"f");
        map.put(7,"g");
        map.put(8,"h");
        map.put(9,"y");
        map.put(10,"w");
        map.put(13,"d1");
        map.put(43,"d1");
        map.put(34,"d1");
        map.put(134,"d1");
        map.put(334,"d1");
        map.put(433,"d1");
        map.put(4313,"d2");
        map.put(43333,"d3");
        map.put(43313,"d4");
        map.put(34133,"d5");
        map.put(31314,"d6");
        map.put(13143,"d7");
        map.put(41331,"d8");
        map.put(43123,"d9");



    }



    @Test
    public void test1(){

        for(int i = 1; i < 1000; i++){
            if(128 % i == 2){
                System.out.println(" i = " + i);
            }
        }

    }

}
