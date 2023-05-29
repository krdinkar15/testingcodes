package com.coding.linkedList;

import com.coding.linkedList.common.ListNode;
// Problem link : https://leetcode.com/problems/middle-of-the-linked-list/description/
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
            fast=fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode lst=new ListNode(1,new ListNode(2,new ListNode(6)));
        MiddleOfLinkedList midd=new MiddleOfLinkedList();
        System.out.println(midd.middleNode(lst).val);

    }
}
