package com.sky.leetcode.likend;

import org.junit.Test;

import java.util.List;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5
 在真实的面试中遇到过这道题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestRemoveElements {

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
     *  虚拟表头法 快慢指针
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        //虚拟头节点 类似前置指针
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead,curr = head;

        while (curr != null){

            if( curr.val == val) {
                prev.next = curr.next;
            }else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }


    /**
     * 递归法  简洁 链表越长 速度越慢
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val){
        if(head == null) return head;

        //判断节点是否为空 进行递归
        if(head != null){
            head.next = removeElements(head.next,val);
        }
        //判断相等返回下一个节点 不相等返回当前节点
        return  head.val == val ? head.next : head;
    }

    @Test
    public void testRemoveElements(){
        int[] arr1 = new int[]{1,2,6,6,3,4,5,6};
        int val = 6;
        ListNode l1 = createListNode(arr1);
        System.out.println("创建链表的结构");
        printLikend(l1);

        ListNode res = removeElements(l1,val);
        System.out.println("移除元素 "+ 6 +" 后的链表");
        printLikend(res);

    }
}
