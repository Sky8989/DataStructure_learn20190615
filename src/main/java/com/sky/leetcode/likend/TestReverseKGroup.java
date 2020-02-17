package com.sky.leetcode.likend;

import org.junit.Test;

import java.util.List;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 k 是一个正整数，它的值小于或等于链表的长度。

 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 示例 :

 给定这个链表：1->2->3->4->5

 当 k = 2 时，应当返回: 2->1->4->3->5

 当 k = 3 时，应当返回: 3->2->1->4->5

 说明 :

 你的算法只能使用常数的额外空间。
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestReverseKGroup {
    public void printLikend(ListNode l1){

        ListNode curr = l1;
        while (true){
            System.out.print(curr.val + "\t");
            if(curr.next != null){
                curr = curr.next;
            }else {
                System.out.println();
                break;
            }
        }
    }
    public ListNode createListNode(int[] arr){
        ListNode l1 = new ListNode(0);
        ListNode curr = l1;
        for(int i = 0; i < arr.length; i++){
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = new ListNode(arr[i]);
        }

        return l1.next;
    }
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     *
     * 虚拟头节点， 三指针法  prev curr next
     *翻转链表
     * @param head 链表
     * @param k 指定翻转的个数
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        //初始化 前置指针  后置指针
        ListNode prev = dummyHead,end = dummyHead;

        while(end.next != null){
            // end的位置为待翻转链表的最后一个节点
            for(int i = 0; i < k && end != null; i++) end = end.next;

            if(end == null) break;
            //翻转中链表的起始节点
            ListNode start = prev.next;
            //end节点的 下一个节点
            ListNode next = end.next;

            // 将正在翻转链表end.next制空方便翻转
            end.next = null;
            //翻转后赋值给前置指针 方便返回
            prev.next = reverse(start);

            /**
             *为待翻转链表 进行初始化
             * 将之前因为翻转 先制空的 end.next = null  进行连接
             */
            start.next = next;
            //因为翻转 start和end的位置发生了交换,  prev和end先保存同一节点
            prev = start;
            end = prev;
        }

        return dummyHead.next;
    }





     public ListNode reverse(ListNode head){
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        ListNode next;
        while (head != null){
            next = head.next;
            head.next = curr.next;
            curr.next = head;

            head = next;
        }
        return dummyHead.next;
     }




    @Test
    public void TestReverse(){
       int[] arr = new int[]{1,2,3,4,5};
       int k = 3;

       ListNode l1 = createListNode(arr);
       System.out.println("创建链表后的结构");

       printLikend(l1);

//       ListNode res = reverse(l1);
       ListNode res = reverseKGroup(l1,k);
        System.out.println("返回结果后的链表 ：");

        printLikend(res);
    }
}
