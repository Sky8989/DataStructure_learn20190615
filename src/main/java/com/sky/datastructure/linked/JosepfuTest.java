package com.sky.datastructure.linked;

import org.junit.Test;

/**
 * 约瑟夫问题
 * 环形链表
 */
public class JosepfuTest {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("ListNode{");
            sb.append("val=").append(val);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }

    /**
     * n 总人数
     * k 编号 k (1 <= k <= n )
     *
     */
    @Test
    public void josepfu(){

        int n = 6;
        //1:构造一个环形链表 参数n
        ListNode l1 =  generateLiked(n);

        System.out.println("l1 ===" + l1);

    }

    /**
     * 构造一个长度为 n 的环形链表
     * @param n
     * @return
     */
    private ListNode generateLiked(int n) {

        //空的头结点
        ListNode result = new ListNode(0);

        for(int i = 1; i <= n ; i++){
           ListNode news = new ListNode(i);
           //当前结点
           ListNode curr = result;

            /**
             * 注意 要判断的是当前结点的下一个结点不为空时
             */
           while (curr.next != null){
               curr = curr.next;
           }
           curr.next  = news;

            /**
             * 环形链表最后处理
             */
            if(i == n){
                result = result.next;
               curr.next = result;
//                while (result.next != null){
//                  result = result.next;
//                }
//                result = result.next;
//
           }
        }

        return result;
    }
}
