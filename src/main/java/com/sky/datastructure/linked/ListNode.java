package com.sky.datastructure.linked;

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
        sb.append('}');
        return sb.toString();
    }
}
