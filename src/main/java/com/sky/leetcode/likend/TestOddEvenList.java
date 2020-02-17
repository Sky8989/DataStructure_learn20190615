package com.sky.leetcode.likend;

import org.junit.Test;

import java.util.List;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

 示例 1:

 输入: 1->2->3->4->5->NULL
 输出: 1->3->5->2->4->NULL
 示例 2:

 输入: 2->1->3->5->6->4->7->NULL 
 输出: 2->3->6->7->1->5->4->NULL
 说明:

 应当保持奇数节点和偶数节点的相对顺序。
 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestOddEvenList {
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
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起（类似数组的下标 奇数放前面，偶数放后面）。
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        // 奇数，偶数 ，偶数链表
        ListNode odd = head, even = head.next, evenHead = even;
        //偶数在后面，当偶数不为空时才能循环操作
        while (even != null && even.next != null) {
            // 将奇数链表下一个删除
            odd.next = odd.next.next;
            //奇数下移
            odd = odd.next;
            //偶数下一个删除
            even.next = even.next.next;
            //偶数下移
            even = even.next;
        }
        //最后将 奇数的下一个为 偶数 链表
        odd.next = evenHead;
        return head;

    }

    @Test
    public void testList(){
        int[] arr = new int[]{1,2,3,4,5,6};

        ListNode l1 = createListNode(arr);

        System.out.println("创建后的链表：");

        printLikend(l1);

        System.out.println("执行后的链表结构：");

        ListNode res = oddEvenList(l1);

        printLikend(res);
    }
}
