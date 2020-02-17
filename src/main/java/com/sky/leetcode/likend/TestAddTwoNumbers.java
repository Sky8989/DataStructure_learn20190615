package com.sky.leetcode.likend;

import org.junit.Test;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：
 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestAddTwoNumbers {

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
     * 注意点：考虑链表扩容 如 l1=[5] l2=[5] ==> [0,1]
     * 顺序操作
     * 1： l1.val+l2.val > 10   ten=1 表示下一次需要进位
     * 1.1   l1.val+l2.val < 10 不用进位 需要ten 是否为1 为1  在l1.val+l2.val的基础上+1
     * 2： 判断l1 后l2 是否不为空，怕出现 l1,l2长度不一致
     *  2.1 假设l1 不为空，判断ten=1 新增节点的数值 = l1.val+1， ten=0 的话不+1
     *  2.2 假设l2 不为空，判断ten=1 新增节点的数值 = l2.val+1， ten=0 的话不+1
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        ListNode t1 = l1, t2 = l2;

        //两数之和大于10存下十位 进行进位
        int ten = 0;
        while(true){
            if(t1 == null && t2 == null){
                break;
            }else if(t1 != null && t2 != null){
                int sum = t1.val+t2.val;

                //分4中情况，ten=1的两种 ten=0的2种
                if(ten == 1 && sum + ten >= 10){
                    curr.next = new ListNode( (sum + ten) % 10);
                }else if(ten == 1 && sum + ten < 10){
                    curr.next = new ListNode((sum + ten ) % 10 );
                    ten--;
                }else if(ten == 0 && sum >= 10){
                    curr.next = new ListNode(sum % 10);
                    ten++;
                }else {
                    //ten = 0
                    curr.next = new ListNode(sum);
                }
                //移动
                t1 = t1.next;
                t2 = t2.next;

            }else if(t1 != null){
                //考虑大于10 理解版本
//                if(ten == 1 && ten + t1.val >= 10){
//                    //ten不处理 加完 ten 又需要减
//                    curr.next = new ListNode((ten + t1.val) % 10);
//                } else{
//                    curr.next = new ListNode(ten == 1 ? ten-- + t1.val : t1.val);
//                }

                //简写版本
                curr.next = new ListNode( ten == 1 && (ten + t1.val) >= 10 ?
                                        (ten + t1.val) % 10
                                        :
                                        ten == 0 ? t1.val : t1.val + ten--);

                t1 = t1.next;
            }else if(t2 != null){
                //考虑大于10  理解版本
//                if(ten == 1 && ten + t2.val >= 10){
//                    curr.next = new ListNode((ten + t2.val) % 10);
//                }else{
//                    curr.next = new ListNode(ten == 1 ? t2.val+ ten-- : t2.val);
//                }

                //简写版本
                curr.next = new ListNode( ten == 1 && (ten + t2.val) >= 10 ?
                        (ten + t2.val) % 10
                        :
                        ten == 0 ? t2.val : t2.val+ ten--);

                t2 = t2.next;
            }
            //汇合到一起后移
            curr = curr.next;
        }
        if(ten == 1){
                curr.next = new ListNode(1);
                ten--;

        }

        return dummyHead.next;
    }

    /**
     * addTwoNumbers 代码优化
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersPro(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead, t1 = l1,t2 = l2;

        //两数之和大于10存下十位 进行进位
        int ten = 0;
        while(t1 != null|| t2 != null){
            //t1,t2 判空同时初始化 (节省很多if else)
            int x = (t1 != null) ? t1.val : 0;
            int y = (t2 != null) ? t2.val : 0;

                int sum = x + y + ten;
                //ten = 1下一个数需要进位，ten = 0下一个数不需要进位
                ten = sum / 10;
                //注意小于10的数对10取余 等于本身
                curr.next = new ListNode(sum % 10);
                //移动
                curr = curr.next;
               if(t1 != null) t1 = t1.next;
               if(t2 != null) t2 = t2.next;
        }
        //最后判断是否扩容链表
        if(ten == 1){
            curr.next = new ListNode(ten--);
        }
        return dummyHead.next;
    }

    public ListNode reverseList(ListNode l1){
       ListNode dummyHead = new ListNode(0);
       ListNode next = null;

       while(l1 != null){
           next = l1.next;
          l1.next =  dummyHead.next;
          dummyHead.next = l1;
          l1 = next;
       }

       return dummyHead.next;
    }

    @Test
    public void testTwoNumber(){


        int[] a1 = new int[]{9,9};
        int[] a2 = new int[]{9,9};

//        int[] a1 = new int[]{2,4,7,8};
//        int[] a2 = new int[]{2,6,3};

//        int[] a1 = new int[]{2,4,3};
//         int[] a2 = new int[]{5,6,4};

//        int[] a1 = new int[]{5};
//        int[] a2 = new int[]{5};

//        int[] a1 = new int[]{1};
//        int[] a2 = new int[]{9,9};

        ListNode l1 = createListNode(a1);
        ListNode l2 = createListNode(a2);

        System.out.println("创建后输出");
        printLikend(l1);
        printLikend(l2);

        System.out.println("操作后的结果");
        ListNode res = addTwoNumbersPro(l1,l2);
        printLikend(res);

    }
    
}
