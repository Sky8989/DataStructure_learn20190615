package com.sky.datastructure.linked;

import java.util.Objects;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
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

    public void add(ListNode obj){
         ListNode head = this;

         while (head.next != null)
         {
             head = head.next;
         }

             head.next = obj;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
