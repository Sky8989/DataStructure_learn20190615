package com.sky.leetcode.likend;

import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 进阶:

 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 示例:

 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出: 7 -> 8 -> 0 -> 7
 
 注意：计算进位

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestAddTwoNumbers2 {
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
     * 使用双栈
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead,t1 = l1,t2 = l2;

        //加入到栈中
       while (t1 != null){
           s1.push(t1.val);
           t1 = t1.next;
       }
       while (t2 != null){
           s2.push(t2.val);
           t2 = t2.next;
       }

       int ten = 0;
       while (!s1.isEmpty() ||  !s2.isEmpty() || ten > 0){

           //初始化两个链表的值
           int n1 = s1.isEmpty() ? 0 : s1.pop();
           int n2 = s1.isEmpty() ? 0 : s2.pop();

           int sum = n1 + n2 + ten;
           ten = sum / 10;
           //反转 头插法
           ListNode newNode = new ListNode(sum % 10);
           newNode.next = curr.next;
           curr.next = newNode;

       }
       return dummyHead.next;
    }

    @Test
    public void testAdd(){
        int[] a1 = new int[]{7,2,4,3};
        int[] a2 = new int[]{5,6,4};

        ListNode l1 = createListNode(a1);
        ListNode l2 = createListNode(a2);

        System.out.println("创建成功后的链表结构");
        printLikend(l1);
        printLikend(l2);

        ListNode res = addTwoNumbers(l1,l2);
        System.out.println("相加后返回的链表结构");

        printLikend(res);

        System.out.println("之前传入的链表结构");
        printLikend(l1);
        printLikend(l2);

    }
}
