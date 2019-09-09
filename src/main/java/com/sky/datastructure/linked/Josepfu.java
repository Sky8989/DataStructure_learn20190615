package com.sky.datastructure.linked;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

public class Josepfu {

    public static void main(String[] args) {
        Boy boy = new Boy(0);
        boy.createBoy(5);

        System.out.println(boy.size());
    }



    static class Boy{
        int no;
        Boy next;

        public Boy(int no){
            this.no = no;
        }

        @Override
        public String toString() {
            return "Boy{" +
                    "no=" + no +
                    '}';
        }

        public void createBoy(int size){
            if(size < 0){
                System.out.println("传入参数有误");
                return;
            }

            Boy cur =  next;
            for(int i = 1; i <= size; i++){
                cur = new Boy(i);
                cur = cur.next;
            }
            next = cur;

        }

        public int size(){
            Boy cur = next;
            int size = 0;
            while (cur != next){
                size ++;
                cur = cur.next;
            }
            return size;
        }



    }
}
