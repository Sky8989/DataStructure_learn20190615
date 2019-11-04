package com.sky.datastructure.linked;

import org.junit.Test;

/**
 * 插入排序算法：
 *
 *     1:插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 *     2:每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 *     3:重复直到所有输入数据插入完为止。
 *

 */
public class InsertSortTest {

    /**示例 1：
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     *
     *示例 2：
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {

        ListNode index = head.next;

        while (true){
         int num = index.val;
            ListNode index1 = head;

            while ( (index1 != null && index1.val > index.val) ){
                index.val = index1.val;
                index1 = index1.next;
            }
            index1.val = num;


            //少一次遍历
            if(index == null){
                break;
            }

            index = index.next; //++
        }
        return head;
    }

    @Test
    public void insertSort(){
        ListNode head = new ListNode(4);
       head.add(new ListNode(2));
       head.add(new ListNode(1));
       head.add(new ListNode(3));



        System.out.println(head);

        head =  insertionSortList(head);
        System.out.println("========= " + head);
    }
}
