package com.sky.leetcode.likend;

import org.junit.Test;

import java.util.List;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 示例:

 给定 1->2->3->4, 你应该返回 2->1->4->3.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSwapPairs {
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
     * 两两交换其中相邻的节点，不是交换值，实际节点交换。
     * 虚拟头节点，双指针 一个前置指针 一个当前指针
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return  head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode curr = dummyHead, prev = null;

        while (curr.next != null && curr.next.next != null){

            // 1->2->3->4
            prev = curr.next;
            // 2->3->4
            ListNode nextNode = curr.next.next;

            //进行交换
            // 1->3->4
            prev.next = prev.next.next;
            // 2->1->3->4
            nextNode.next = prev;
            //2->1->3->4
            curr.next = nextNode;

            //移动两步
            curr = curr.next.next;

        }
        return dummyHead.next;
    }

    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head){

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;

        while (head != null && head.next != null){
            ListNode first = head;
            ListNode second = head.next;

            //交换 1->2->3->4 --> 2->3->4
            prev.next = second;
            first.next = second.next;  //1->2->3->4 --> 1->3->4
            second.next = first;  // 2->3->4  --> 2->1->3->4

            //重新初始化 prev和 first 进下一次交换 比较难理解的点
            prev = first;
            head = first.next;

        }
        return dummyHead.next;

    }

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;

        // 1->2-3->4 --> 1->3->4
        first.next = swapPairs2(second.next);
        // 2->3->4 --> 2->1->3->4
        second.next = first;

        return second;
    }
    @Test
    public void testSwap(){
        int[] arr = new int[]{1,2,3,4,5,6};

        ListNode l1 = createListNode(arr);
        System.out.println("创建后的链表为：");
        printLikend(l1);

        ListNode res = swapPairs2(l1);
        System.out.println("交换位置后的链表：");

        printLikend(res);
    }
    
    
}
