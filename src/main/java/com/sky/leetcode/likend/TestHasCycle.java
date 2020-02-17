package com.sky.leetcode.likend;

import org.junit.Test;

/**
 * 给定一个链表，判断链表中是否有环。

 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 示例 1：

 输入：head = [3,2,0,-4], pos = 1   (  3 -> 2 -> 0 -> -4 [指向下标为1的节点] 2 )
 输出：true
 解释：链表中有一个环，其尾部连接到第二个节点。


 示例 2：

 输入：head = [1,2], pos = 0   (1->2-> [指向下标为0的节点])
 输出：true
 解释：链表中有一个环，其尾部连接到第一个节点。


 示例 3：

 输入：head = [1], pos = -1
 输出：false
 解释：链表中没有环。

 进阶：

 你能用 O(1)（即，常量）内存解决此问题吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/linked-list-cycle
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestHasCycle {

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
        ListNode(int x) { val = x;  next = null; }
    }

    /**
     * 判断链表中是否有环,不应该破坏链表的结构
     * 使用快慢指针法
     *  思路：
     *   1：快指针一次走两步， 慢指针一次一步，如果没有环 快指针最终为空
     *   2：如果存在环 最终快指针 会和 慢指针 相遇
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        //快慢指针
        ListNode fast = head,slow = head;
        /**
         * 判断界限
         */
        while (fast.next != null && fast.next.next != null){

            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    @Test
    public void testLiked(){
        int[] arr = new int[]{3,2,0,-4};
        int pos = 1;

        ListNode l1 = createRingListNode(arr,pos);



        boolean flag = hasCycle(l1);

        System.out.println("判断后是否环 =  " + flag );

    }

    private ListNode createRingListNode(int[] arr, int pos) {


        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        for(int i = 0; i < arr.length; i++){
            ListNode newNode = new ListNode(arr[i]);
            curr.next = newNode;
            curr = curr.next;
        }
        int i = 0;
       ListNode next = null;
               curr = dummyHead;

        while (curr.next != null){

            if(i == pos){
                next = curr;
            }

            curr = curr.next;
            i++;
        }

        if(next != null){
            curr.next = next;
        }


        return dummyHead.next;

    }
}
