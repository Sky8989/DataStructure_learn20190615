package com.sky.leetcode.likend;

import org.junit.Test;

/**
 *反转一个单链表。
 示例:
 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 //解决方法
 1：递归
 2：头插法

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestReverseList {

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
     * 反转一个单链表  迭代法
     * 需要两个指针 一个当前指针 一个next指针(保存当前指针next的所有节点)
     * 注意：破坏了head的结构
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null)return head;

        ListNode curr = head;
        ListNode next;

        ListNode dummyHead = new ListNode(0);

        while (curr != null){

            next = curr.next;
            curr.next = dummyHead.next;
            dummyHead.next = curr;
            curr = next;
//            if(curr.next != null){
//                //先保存next节点
//                next = curr.next;
//                /**
//                 * 将返回链表的next节点赋值给当前节点的下一个 比如 dummyHead  = 0->null   curr = 1->2->3
//                 * curr.next = dummyHead.next  -->    curr = 1-> null
//                 * dummyHead.next = curr  --> dummyHead = 0->1->null
//                 * curr = next -> curr = 2->3->null 如此反复就将head链表给反转了
//                 *
//                 */
//                curr.next = dummyHead.next;
//                dummyHead.next = curr;
//                curr = next;
//            }else {
//                next = curr.next;
//                curr.next = dummyHead.next;
//                dummyHead.next = curr;
//                curr = next;
//            }
           }
        return dummyHead.next;
    }

    /**
     * 反转单链表 迭代法    使用头插法保证head链表结构不变
     * 优化版本反转后保证head链表结构不改变
     * @param head
     * @return
     */
    public ListNode reverseListPro(ListNode head){
        if(head == null) return head;

        ListNode dummyHead = new ListNode(0);
        ListNode curr = head;
        ListNode res = dummyHead;

        while (curr != null){

            //第一次插入
            if(res.next == null){
                res.next = new ListNode(curr.val);

            }else {
                //头插法
                ListNode newNode = new ListNode(curr.val);
                newNode.next = res.next;
                res.next = newNode;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }

    /**
     * 使用递归法 实现反转单链表  骚气解法，非常不好理解
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head){
        if(head == null || head.next == null) return head;

        //最后一个节点
        ListNode res = reverseList1(head.next);
        /**
         * 链表成环
         * 假设 最开始 head = 1->2->3->4->5，最后一次递归时， res = 5 head的结构为 4->5->null
         * 通过 head.next.next = head;操作   4->5->4->5 成环 将head.next 指向 head  4->5  变成 5->4 (res)  head(4->head)
         */
        head.next.next = head;
        /**
         * 防止链表循环，需要将head.next设置为空   4->null->5->4 此时返回的res为4
         */
        head.next = null;
       return res;

    }

    /**
     * 更好理解的递归方式 类似循环式反转
     */
    ListNode dummyHead = new ListNode(0);
    ListNode next;
    public ListNode reverseList1Pro(ListNode head){
        //注意这个是一次性返回 反转后链表
        if(head == null) return dummyHead.next;

        //链表反转操作
        next = head.next;
        head.next = dummyHead.next;
        dummyHead.next = head;

        return reverseList1Pro(next);
    }

    /**
     * 递归法 网友详细理解版本
     * @param head
     * @return
     */
    public ListNode reverseListNet(ListNode head) {
        // 如果当前要反转的节点为 null 或者反转链表为 null
        // head.next 为 null，即反转链表的尾结点不存在，即反转链表不存在
        if (head == null || head.next == null) return head;
        // 节点 p 其实就是反转链表的头节点
        ListNode p = reverseListNet(head.next);
        // 我们将反转链表的尾结点（head.next）的 next 指向当前即将反转的节点
        head.next.next = head;
        // 然后让当前节点变成反转链表的尾结点
        head.next = null;
        // 返回反转链表的头结点
        return p;
    }



    @Test
    public void testReverseList(){
        int[] arr = new int[]{1,2,3,4,5};
        ListNode l1 = createListNode(arr);
        System.out.println("创建完链表");
        printLikend(l1);

       ListNode r1 =  reverseListNet(l1);
       printLikend(l1);
        System.out.println("反转后的链表");
       printLikend(r1);
    }

}
