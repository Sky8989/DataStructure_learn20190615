package com.sky.datastructure.linked;

import org.junit.Test;

import java.math.BigDecimal;

public class AddTwoNumbers {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("ListNode{");
            sb.append("val=").append(val);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(0);
//        l1.next.next = new ListNode(0);
//        l1.next.next.next = new ListNode(1);

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(1);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

/**
 * 2 -> 4 -> 3
 * 5 -> 6 -> 4
 *
 *   342 + 465 = 807
 */
       ListNode r1 =  addTwoNumbers(l1,l2);

        System.out.println("== r1 == " + r1);



    }

  //  @TestRemoveNthFromEnd
    public  void testadd(){
        ListNode l1 = new ListNode(1);

        int len = 31;
//        ListNode curr = l1;
        int i = 0;
        while (len > i){
            i++;

            ListNode newNode = new ListNode(0);
            ListNode curr = l1;

            while (curr.next != null){
                curr = curr.next;
            }

            curr.next = newNode;

            if(i == len){
                ListNode n1 = new ListNode(1);
                curr.next = n1;

            }

        }
        System.out.println("l == " + l1);

        add(l1);

    }


    public  static void add(ListNode r1){

        ListNode head1 = r1;
        BigDecimal sum1 = BigDecimal.ZERO;

        while (head1 != null){

            BigDecimal num = new BigDecimal(head1.val);

            /**
             * 找到规律 sum1 用来存链表最终的值  num用来存每个结点的值
             * 从第一个结点开始 sum1的值 *10  同时加上当前结点的值
             *
             */
//            sum1 =  (sum1*10) + num;
            sum1 = sum1.multiply(new BigDecimal(10)).add(num);

            head1 = head1.next;
        }

        System.out.println("sum1 === " + sum1);
    }

    /**
     * 思路：
     *
     * 1. 先定义一个节点 reverseHead = new HeroNode();
     2. 从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端.
     3. 原来的链表的head.next = reverseHead.next

     * @param l1
     * @return
     */
    public static ListNode listNodeLx(ListNode l1){

        //头结点 当前链表第一个
        ListNode head = l1;

        //用来存 head结点 后面一个结点
        ListNode nextNode = null;

        //反转链表
        ListNode reverseNode = new ListNode(0);

        while(true){

                //先存下一个结点
                nextNode = head.next;

                // head.next = null;
                //将反转链表的第一个结点  赋值给头结点的next  因为新的反转链表第一个结点为空(省略将head结点的下一个直接赋为空)
                 head.next = reverseNode.next;

                 //将头结点 赋值给反转链表的第一个结点
                 reverseNode.next = head;

                 //将 head结点 的下一个节点赋值给head结点
                 head = nextNode;

                 if(head == null)
                     break;
            }

            return reverseNode.next;

        }






  public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        //1:先逆序
            //1.1使用另一个链表存逆序后的数据

      ListNode r1 = listNodeLx(l1);
      ListNode r2 = listNodeLx(l2);

        //2:然后遍历拿出来
      long sum1 = 0L;
//      BigDecimal sum1 = BigDecimal.ZERO;
//      BigDecimal sum2 = BigDecimal.ZERO;
      long sum2 = 0L;

      ListNode head1 = r1;
      ListNode head2 = r2;

      while (head1 != null){

          int num = head1.val;
//          BigDecimal num = new BigDecimal(head1.val);

          /**
           * 找到规律 sum1 用来存链表最终的值  num用来存每个结点的值
           * 从第一个结点开始 sum1的值 *10  同时加上当前结点的值
           *
           */
         sum1 =  (sum1*10) + num;

//          sum1.multiply(new BigDecimal(10)).add(num);

         head1 = head1.next;
      }

      while (head2 != null){

          int num = head2.val;

//          BigDecimal num = new BigDecimal(head1.val);
          sum2 =  (sum2*10) + num;

//          sum2

          head2 = head2.next;
      }

      System.out.println("sum1 == " + sum1);
      System.out.println("sum2 == " + sum2);
        //3:进行计算

                                                                                                                                                                                                                                          //807
         Long sum =  sum1 + sum2;


         String  strSum = sum.toString();
      System.out.println("sum == " + sum);

     //4:返回一个链表

      ListNode resultListNode = new ListNode(0);


      long prefix = -1;

      long suffix = -1;
      int len = 0;
      while (strSum.length() > len ){

          len++;

          prefix =  Math.abs(sum / 10);

          suffix = Math.abs(sum % 10);

          sum = prefix;


          //判断是否大于0
//          if(sum < 0) {
//              if (prefix < 10 && prefix != 0) {
//                  prefix = -prefix;
//              }
//          }

          //sum的从头到尾 没一个数 放入新结点中
          ListNode newNode = new ListNode((int)suffix);

          ListNode curr = resultListNode;
         while (curr.next != null){
             curr = curr.next;
         }
          curr.next = newNode;


      }

      return  resultListNode.next;
  }

//  @TestRemoveNthFromEnd
//    public void testchu(){
//        int n1 = 807;
//
//
//      int q = n1 / 10;
//      System.out.println(q);
//      int y = n1 % 10;
//      System.out.println(y);
//
//      n1 = q;
//      q = n1 / 10;
//      System.out.println("q = " + q);
//      y = n1 % 10;
//      System.out.println("y = " + y);
//
//      n1 = q;
//
//      q  = n1 / 10;
//      System.out.println("== q " +q);
//      y = n1 % 10;
//      System.out.println("== y " + y);
//
//
//  }
}
