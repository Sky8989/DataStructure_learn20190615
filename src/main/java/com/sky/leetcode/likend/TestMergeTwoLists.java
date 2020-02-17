package com.sky.leetcode.likend;

import org.junit.Test;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class TestMergeTwoLists {

    /**
     * Definition for singly-linked list.
     *
     *
     **/

     public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 使用 迭代法 虚假表头
     * 优化版本 不破坏l1,l2的结构
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummyHead = new ListNode(0);

        ListNode curr = dummyHead;

        ListNode t1 = l1;
        ListNode t2 = l2;

        while (t1 != null && t2 != null){
            /**
             * 判断大小，确定指针移动的方向
             * 同时将对应的指针往后移动
             */
            if(t1.val > t2.val){
                curr.next = new ListNode(t2.val);
                curr = curr.next;
                t2 = t2.next;
            }else{
                curr.next = new ListNode(t1.val);
                curr = curr.next;
                t1 = t1.next;
            }
        }

        while (t1 != null){
            curr.next = new ListNode(t1.val);
            curr = curr.next;
            t1 = t1.next;
        }

        while (t2 != null){
            curr.next = new ListNode(t2.val);
            curr = curr.next;
            t2 = t2.next;
        }

         return dummyHead.next;
    }

    /**
     * 使用 迭代法 虚假表头
     * 优化版本 不破坏l1,l2的结构, 在优化一个while解决问题
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1pro(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummyHead = new ListNode(0);
        //当前节点
        ListNode curr = dummyHead;

        ListNode t1 = l1,t2 = l2;

        while (true){
            if(t1 == null && t2 == null) break;

            //同时不为空
            if(t1 != null && t2 != null){
                if(t1.val > t2.val){
                    curr.next = new ListNode(t2.val);
                    t2 = t2.next;
                }else {
                    curr.next = new ListNode(t1.val);
                    t1 = t1.next;
                }
            } else if(t1 != null){ //一个不为空，一个为空
                curr.next = new ListNode(t1.val);
                t1 = t1.next;
            }
            else if(t2 != null){
                curr.next = new ListNode(t2.val);
                t2 = t2.next;
            }
            //当前指针统一后移
            curr = curr.next;
        }
        return dummyHead.next;
    }

    /**
     * 使用 迭代法 虚假表头
     * @param l1
     * @param l2
     * @return
     * 问题：改变了l1 l2的结构 是否尝试通过拼接数字 存入到新的列表，从而不去破坏l1,l2链表的结构
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        if(l1 == null) return l2;
        if(l2 == null) return l1;

        /**
         * 使用虚假表头
         */
        ListNode dummyHead  = new ListNode(0);

        ListNode curr = dummyHead;

        //当前位置节点
        ListNode t1 = l1;
        //用来保存当前位置的下一个指针的所有节点
        ListNode t2 = l2;

        while (t1 != null && t2 != null){
            /**
             *通过移动 t1 t2 实现拼接到新的链表，同时通过t1 t2判断结束
             *
             */
            if(t1.val > t2.val){
                //curr有一个头 t2赋值给curr下一个节点
                curr.next = t2;
                //curr后移 方便存储
                curr = curr.next;
                //移动指针
                t2 = t2.next;

            }else{

                curr.next = t1;
                curr = curr.next;
                 t1 = t1.next;
            }
        }

        return dummyHead.next;
    }


    /**
     * 递归法
     * @param l1
     * @param l2
     * @return
     * 弊端 破坏了l1,l2 链表的结构
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;


        if(l1.val > l2.val){
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }else {
           l1.next = mergeTwoLists2(l1.next,l2);
           return l1;
        }

    }

    @Test
    public void testLikend(){
        int[] a1 = new int[]{1,2,4};
        int[] a2 = new int[]{1,3,4};

        ListNode l1 = createListNode(a1);
        ListNode l2 = createListNode(a2);

        System.out.println("创建链表后的结构 ");
       printLikend(l1);
       printLikend(l2);

       ListNode r1 = mergeTwoLists2(l1,l2);

        System.out.println("合并后链表的结构");

        printLikend(r1);

        System.out.println("-------");
        printLikend(l1);
        printLikend(l2);



    }
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
}
