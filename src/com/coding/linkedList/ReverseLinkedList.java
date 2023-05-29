package com.coding.linkedList;

import com.coding.linkedList.common.ListNode;
// Problem link : https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head)
    {
        if(head==null)
            return null;
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null)
        {
            ListNode ahead=curr.next;
            curr.next=prev;
            prev=curr;
            curr=ahead;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode lst=new ListNode(1,new ListNode(5,new ListNode(7,new ListNode(9,new ListNode(2)))));
        ListNode ans=reverseList(lst);
        while(ans!=null)
        {
            System.out.println(ans.val);
            ans=ans.next;

        }
    }
}
