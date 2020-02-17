package com.sky.datastructure.linked;

import org.junit.Test;

/**
 * 约瑟夫问题
 * 环形链表
 */
public class JosepfuTest {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

//        @Override
//        public String toString() {
//            final StringBuilder sb = new StringBuilder("ListNode{");
//            sb.append("val=").append(val);
//         //   sb.append(", next=").append(next);
//            sb.append('}');
//            return sb.toString();
//        }
    }

    class LikedList{

      private  ListNode first = null;

        /**
         * 创建一个指定长度的 单向环形链表
         * @param nums
         */
      public void createLikedList(int nums){

          if(nums <= 0){
              System.out.println("创建的参数 不能小于或等于 0" + nums);
              return;
          }
          ListNode curr = null;
          for(int i = 1 ; i <= nums; i++){

              ListNode  news = new ListNode(i);
              if(i == 1){

                 first = news;
                 first.next = first;
                 curr = first;

              }else{
                  curr.next = news;
                  news.next = first;
                  curr = news;

              }
          }

      }

      public void showLikedList(){

          ListNode curr = first;

        for(int i = curr.val; ; curr = curr.next){
            System.out.println(curr.val);

            if(curr.next == first){
                break;
            }
        }
      }


    }



    /**
     * n 总人数
     * k 编号 k (1 <= k <= n )
     *
     */
    @Test
    public void josepfu(){


        int n = 6;
        //1:构造一个环形链表 参数n
        LikedList liked = new LikedList();

        liked.createLikedList(6);

        liked.showLikedList();

    }



}
