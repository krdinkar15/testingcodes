package com.linkedList;

import com.linkedList.common.ListNode;
// Problem link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head;
        ListNode fast=head;
        for(int i=0;i<n;i++)
        {
            fast=fast.next;
        }
        if(fast==null)
            return head.next; // Deleting the 1st node
        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
