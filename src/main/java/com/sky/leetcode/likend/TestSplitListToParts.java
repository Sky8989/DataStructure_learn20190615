package com.sky.leetcode.likend;

import org.junit.Test;

import java.util.List;

/**
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。

 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。

 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。

 返回一个符合上述规则的链表的列表。

 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]

 示例 1：

 输入:
 root = [1, 2, 3], k = 5
 输出: [[1],[2],[3],[],[]]
 解释:
 输入输出各部分都应该是链表，而不是数组。
 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 示例 2：

 输入:
 root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 解释:
 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
  
 提示:
 root 的长度范围： [0, 1000].
 输入的每个节点的大小范围：[0, 999].
 k 的取值范围： [1, 50].

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSplitListToParts {

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
     * 题目描述：把链表分隔成 k 部分，每部分的长度都应该尽可能相同，排在前面的长度应该大于等于后面的。
     *
     * @param root
     * @param k   返回结果的长度
     * @return
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] arr = new ListNode[k];

        if(root == null ) return arr;
        if(k == 1)return arr = new ListNode[]{root};

        //1:求root的长度
        int len = 0;
        ListNode c1 = root;
        while (c1 != null){
            c1 = c1.next;
            len++;
        }
       //余数
        int yu = len % k;
        // 切割后每个链表的长度
        int div = len / k;
            //切割链表开始节点
             ListNode head = root;
             //切割链表开始节点的前一个节点
             ListNode prev = null;

            for(int i = 0; i < k; i++, yu--){
                arr[i] = head;
                //每部分链表的长度
                int part_len = div + ((yu > 0) ? 1 : 0);
                for(int j = 0; j < part_len; j++){
                    prev = head;
                    head = head.next;
                }
                if(prev != null) prev.next = null;
            }
        return arr;
    }

    /**
     * 1：先获取root 的长度 len
     * 2: 通过 len % k = mod   len / k = size(切分后每个链表的大小，size或+1)
     * 3：双重for 外层 保证 链表长度k
     * 3:内层 保证每个被切割链表的长度。
     **/
    public ListNode[] splitListToParts1(ListNode root, int k) {

        ListNode[] arr = new ListNode[k];
        if(k == 1) return arr = new ListNode[]{root};

        ListNode curr = root;
        //root的长度
        int len = 0;
        while (curr != null){
            curr = curr.next;
            len++;
        }

        int yu = len % k;
        int div = len / k;

        curr = root;
        for(int i = 0 ; curr != null && i < k; i++){
            arr[i] = curr;
            int size = div + ((yu-- > 0 ) ? 1 : 0);
            //少走一步，保证curr 相当与prev
            for(int j = 0; j < size - 1; j++){
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return arr;
    }

    public ListNode[] splitListToPartsCopy(ListNode root, int k) {
        ListNode[] arr = new ListNode[k];

        ListNode curr = root;
        int len = 0;
        while (curr != null){
            len++;
            curr = curr.next;
        }

        int mod = len % k;
        int div = len / k;

        ListNode prev = null;
//        ListNode head = root;
        curr = root;
        for(int i = 0; i < k; i++){
            //先给切割前的头节点
            arr[i] = curr;
            int part_size = div + ((mod-- > 0) ? 1 : 0);
            //循环移动 规定的切割长度
            for(int j = 0; j < part_size; j++){
                prev = curr;
                curr = curr.next;
            }
            //切断链表
            if(prev != null) prev.next = null;
        }

        return arr;
    }

    @Test
    public void testSplitList(){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int k = 3;

        ListNode head = createListNode(arr);
        System.out.println("创建后链表的长度");
        printLikend(head);

        ListNode[] nodeList = splitListToPartsCopy(head,k);
        System.out.println("遍历返回结果");
        for(int i = 0; i < nodeList.length; i++){
            printLikend(nodeList[i]);
        }
    }
}
