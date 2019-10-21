package com.sky.datastructure.linked;

import org.junit.Test;

import java.util.*;

/**
 * 一般用在要返回新的链表的题目中，
 * 比如，给定两个排好序的链表，要求将它们整合在一起并排好序。
 * 又比如，将一个链表中的奇数和偶数按照原定的顺序分开后重新组合成一个新的链表，链表的头一半是奇数，后一半是偶数。
 *
 *
 * 在这类问题里，如果不用一个虚假的链表头，
 * 那么在创建新链表的第一个元素时，我们都得要判断一下链表的头指针是否为空，
 * 也就是要多写一条 if else 语句。
 * 比较简洁的写法是创建一个空的链表头，直接往其后面添加元素即可，最后返回这个空的链表头的下一个节点即可。
 *
 *
 * 建议：在解决链表的题目时，
 * 可以在纸上或者白板上画出节点之间的相互关系，
 * 然后画出修改的方法，既可以帮助你分析问题，
 * 又可以在面试的时候，帮助面试官清楚地看到你的思路。
 */
public class Solution {

    @Test
    public void testListNode(){


        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);


      ListNode result = mergeTwoLists2(l1,l2);
      if(result != null){
          while (true){
              System.out.println(result.val);

              if(result.next == null){
                  break;
              }
              result = result.next;
          }
      }
    }

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }


        List<Integer> list = new ArrayList<Integer>();


//        //压入栈中
        while (true) {

            if (l1 != null) {
                list.add(l1.val);
                //下移
                l1 = l1.next;
            }
            if (l2 != null) {
                list.add(l2.val);
                l2 = l2.next;
            }

            if (l1 == null && l2 == null) {
                break;
            }
        }

        //排序
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });


        //取出数据 加入到链表中
        Iterator<Integer> integers = list.iterator();
        //指针
        ListNode temp = head;
        while (integers.hasNext()) {
            Integer val = integers.next();

            if (temp.next == null) {

                temp.next = new ListNode(val);

                temp = temp.next;

            }
            integers.remove();
        }
        return head = head.next;
    }


    /**
     * 迭代
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode point = head;

        while (true) {

            //结束条件
            if (l1 == null && l2 == null) {
                break;
            }

            //循环中两个链表 都为空
            if (l1 != null && l2 != null) {
                //排序 将小的数 先加入到链表中
                if (l1.val >= l2.val) {
                    point.next = new ListNode(l2.val);
                    l2 = l2.next;

                } else {
                    point.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
            } else if (l1 == null) { //循环过程中 l1为空时
                point.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {//循环过程中 l2为空时
                point.next = new ListNode(l1.val);
                l1 = l1.next;
            }

            //移动指针
            point = point.next;

        }


        //去掉头链表
        return head.next;

    }


    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //递归为空时 返回传入时的链表 l2
        if(l1 == null) {
            return l2;
        }
        //递归为空时 返回传入时的链表 l1
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            // 传入时的 l1.next = 返回的结果
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            // 传入时的 l2.next = 返回的结果
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }


}
