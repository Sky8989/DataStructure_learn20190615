package com.sky.test;

import org.junit.Test;

public class Test1 {

    public static void main(String[] args) {



        double tiexian = 0.08;

        double jinglirun = 25.6;

        int year = 10;

        double result = 0;

        for(int i = 0; i <10; i++){
            result += jinglirun/(1+tiexian);
        }

        System.out.println( "极值 假设营业不变 "+ year + "年后的估计市值" + result);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA,b = headB;

        while(a != b){
            a = (a == null) ? a = headB : a.next;
            b = (b == null) ? b = headA : b.next;
        }

        return a;
    }

    @Test
    public void t1(){
        System.out.println(10%3);
        System.out.println(10/3);
    }
}
