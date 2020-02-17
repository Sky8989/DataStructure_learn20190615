package com.sky.leetcode.likend;

import java.util.List;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

 现有一个链表 -- head = [4,5,1,9]，它可以表示为:  4->5->1->9

 示例 1:

 输入: head = [4,5,1,9], node = 5
 输出: [4,1,9]
 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 示例 2:

 输入: head = [4,5,1,9], node = 1
 输出: [4,5,9]
 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
  

 说明:
 链表至少包含两个节点。
 链表中所有节点的值都是唯一的。
 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 不要从你的函数中返回任何结果。

 题意：
 题目是给你一个节点，要求你删除这个节点。
 也就是给我们的是5这个节点，注意给我们的不是一个值，而是要求删除这个节点

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestDeleteNode {
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
     * 迭代法
     * 说明:
     链表至少包含两个节点。
     链表中所有节点的值都是唯一的。
     给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     不要从你的函数中返回任何结果。
     * @param node
     *
     *  题意：
        题目是给你一个节点，要求你删除这个节点。
        也就是给我们的是5这个节点，注意给我们的不是一个值，而是要求删除这个节点
     */
    public void deleteNode(ListNode node) {

        //将下一个节点值赋给当前节点
       node.val = node.next.val;
        //再将当前节点指向 下下一个节点
        node.next = node.next.next;



    }
}
