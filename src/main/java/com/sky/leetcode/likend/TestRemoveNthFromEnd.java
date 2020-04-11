package com.sky.leetcode.likend;

import org.junit.Test;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：

 给定的 n 保证是有效的。
 
 进阶：
 你能尝试使用一趟扫描实现吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestRemoveNthFromEnd {

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

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 双指针法
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
      当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
       ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
       ListNode fast = head,slow = head;

       int len = 0;
       while (fast.next != null && fast.next.next != null){
           fast = fast.next.next;
           slow = slow.next;
           len += 2;
       }

       if(fast.next == null){
           len += 1;
       }else {
           len += 2;
       }

       int i = 0;
       ListNode curr = dummyHead;
       while (i++ < len - n) if(curr.next != null) curr = curr.next;

       curr.next = curr.next.next;

       return dummyHead.next;
    }

    /**
     * 双指针优化版本
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     当删除了倒数第二个节点后，链表变为 1->2->3->5.
     */
    public ListNode removeNthFromEndPro(ListNode head, int n){
        if(head == null || (n == 1 && head.next == null)) return null;
        /**
         * 分析： 找到链表倒数第n个位置的节点进行删除，
         * 1：可以使用快慢指针 让两个指针的距离保持为n
         */
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode fast = dummyHead,slow = dummyHead;

        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummyHead.next;

    }

    public ListNode removeNthFromEndEasy(ListNode head,int n){

        ListNode fast = head,slow = head;

        while(n-- != 0) fast = fast.next;

        if(fast == null) return head.next;

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    @Test
    public  void testRemoveNth(){
     int[] arr = new int[]{1,2,3,4,5};
     int n = 2;

     ListNode l1 = createListNode(arr);
     System.out.println("创建后的链表为：");

     printLikend(l1);

     ListNode res = removeNthFromEndPro(l1,n);
     System.out.println("删除后的链表为： ");

     printLikend(res);

    }
    

}
