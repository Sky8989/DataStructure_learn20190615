package com.sky.leetcode.likend;

import org.junit.Test;

/**
 *请判断一个链表是否为回文链表。

 示例 1:

 输入: 1->2
 输出: false
 示例 2:

 输入: 1->2->2->1
 输出: true
 进阶：
 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestIsPalindromeLiked {

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
     * 快慢指针法 判断回文链表  重点先找个链表的中间节点
     * 注意 破坏了链表结构，想办法优化看不破坏链表结构
      * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return false;

        /**
         * 类似于跳跃表
         * 快指针 0 2 4 6 8 10
         * 慢指针 0 1 2 3 4 5
         * 刚好慢指针为快指针的一半 找到了中间节点
         */
        ListNode fast = head;
        ListNode slow = head;

        //注意判断节点 防止空指针
        while(fast.next != null && fast.next.next != null){
             fast = fast.next.next;
             slow = slow.next;
        }
        //将中间节点进行反转 slow.next为中间节点
        slow =  reverse(slow.next);

        //进行比较
        while (slow != null){
            if(slow.val != head.val) return false;

            slow = slow.next;
            head = head.next;
        }
        return true;

    }

    /**
     * 将head反转 加入到字符串中 通过equals进行比较
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head){

        StringBuilder str1 = new StringBuilder();
        ListNode curr = head;
        while (curr != null){
            str1.append(curr.val);
            curr = curr.next;
        }
        StringBuilder str2 = new StringBuilder();

        head = reverse(head);

        while (head != null){
            str2.append(head.val);
            head = head.next;
        }

        return str1.toString().equals(str2.toString()) ? true : false;

    }

    /**
     * 使用递归法 进行判断回文链表
     */
    ListNode curr = null;
    public boolean isPalindrome2(ListNode head){
        if(head == null || head.next == null) return true;
        /**
         * 为了一个正序链表和一个逆序链表 需要一个逆序方法
         */
        curr = head;
        return  recursive(head);
    }

    public boolean recursive(ListNode head){
        if(head != null){
            // 递归下移 返回false
            if(!recursive(head.next)) return false;
            //递归最后一个节点开始比较  curr从头节点开始 head从尾节点开始
            if(head.val != curr.val)return  false;
            curr = curr.next;
        }
        return true;
    }

    @Test
    public void isPalindrome(){
//        int[] arr = new int[]{1,2};
//        int[] arr = new int[]{1};
        int[] arr = new int[]{1,2,2,1};

        ListNode l1 = createListNode(arr);

        System.out.println("创建链表成功");
        printLikend(l1);

        System.out.println("比较是否为回文链表 = " + isPalindrome2(l1));

        printLikend(l1);
    }

    /**
     * 链表反转
     *
     */
    private ListNode reverse(ListNode head) {
        if(head == null) return null;
        ListNode next = null;
        ListNode dummyHead = new ListNode(0);

        while (head != null){
            next = head.next;
            head.next = dummyHead.next;
            dummyHead.next = head;
            head = next;
        }
        return dummyHead.next;
    }


}
