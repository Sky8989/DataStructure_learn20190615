package com.sky.leetcode.likend;

import org.junit.Test;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。

 如下面的两个链表：
 A:          a1 → a2
                     ↘
                     c1 → c2 → c3
                     ↗
 B:    b1 → b2 → b3

 在节点 c1 开始相交。

 示例 1：
 A:  4 ->1 ->
             ↘
               8->4->5
             ↗
 B: 5 ->0 ->1

 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 输出：Reference of the node with value = 8
 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
  

 示例 2：
 A:  0-> 9 -> 1
                 ↘
                    2->4
                 ↗
 B:          3


 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 输出：Reference of the node with value = 2
 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
  

 示例 3：

 A:  2 -> 6 -> 4

 B:  1-> 5
 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 输出：null
 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 解释：这两个链表不相交，因此返回 null。
  

 注意：

 如果两个链表没有交点，返回 null.
 在返回结果后，两个链表仍须保持原有的结构。
 可假定整个链表结构中没有循环。
 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

 解决方法：
 1：把第一个链表的结尾连接到第二个链表的开头，看第二个链表是否存在环； 让两个链表遍历先相同的长度，A 长度 a + c ,B  b + c 相等的长度c, 解决方法 a+b+c = b+c+a
 2：或者直接比较两个链表的最后一个节点是否相同。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestGetIntersectionNode {

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
     * 假设 headA,headB 两个链表有一段节点相等，长度为 c,
     * headA 总长度减去c 得到不相等长度 a
     * headB 总长度减去c 得到不相等长度 b
     *  因为headA，headB两个链表长度不同，为了保证他们走过的距离相等  可以  (a + c) + (b + c)  = (b + c) + (a + c)
     *   (a + c) + (b + c) 的意思是 headA遍历完链表后接上headB链表继续走完 ，headB进行headA一样的操作  (b + c) + (a + c) 这样就保证了他们走过的距离相等
     *   距离相等下 这样就可以保证他们同时在走的过程中 进行节点判断， 出现相同节点时，表示 headA，headB 想交
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    @Test
    public void testIntersectionNode(){
        int[] a1 = new int[]{4,1,8,4,5};
        int[] a2 = new int[]{5,0,1,8,4,5};

        ListNode l1 = createListNode(a1);
        ListNode l2 = createListNode(a2);

        System.out.println("创建后链表的结构");
        printLikend(l1);
        printLikend(l2);

        ListNode res = getIntersectionNode(l1,l2);
        System.out.println("返回结果");

        printLikend(res);

    }
}
