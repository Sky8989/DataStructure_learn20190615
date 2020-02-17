package com.sky.leetcode.likend;

import org.junit.Test;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

 示例 1:

 输入: 1->1->2
 输出: 1->2
 示例 2:

 输入: 1->1->2->3->3
 输出: 1->2->3

 解决方法：
 1：迭代法
 2：递归法

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestDeleteDuplicates {

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
     * 条件：有序链表
     * 要求：删除所有重复的元素
     *
     * 使用虚拟头节点，双指针
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //前置指针 和 当前指针
        ListNode prev = dummyHead, curr = head;

        while(curr.next != null){
            //当前节点 与下一个节点的值是否重复
            if(prev.next.val == curr.next.val){
                prev.next = curr.next;
            }else{
                //两个节点的值不相等时，将当前节点 赋值给返回节点
                prev = curr;
            }
            curr = curr.next;
        }
         return dummyHead.next;
    }

    /**
     *  简单 迭代法
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesPro(ListNode head){
        ListNode curr = head;

        while (curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return head;
    }

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head){
        if(head == null || head.next == null) return head;

        //递归
         head.next = deleteDuplicates1(head.next);

        //判断
        return head.val == head.next.val ? head.next : head;

    }

    @Test
    public void testDelete(){
        int[] a1 = new int[]{9,9,2,2};

        ListNode l1 = createListNode(a1);
        System.out.println("创建完链表的结构为");
        printLikend(l1);

        ListNode r1 = deleteDuplicates1(l1);
        System.out.println("删除完重复数字后的链表结构为：");
        printLikend(r1);
    }


}
