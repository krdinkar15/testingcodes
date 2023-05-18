package com.linkedList;

import com.linkedList.common.ListNode;

// Problem link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode temp=head;
        while(temp.next!=null)
        {
            if(temp.val==temp.next.val)
            {
                temp.next=temp.next.next;
            }
            else
            {
                temp=temp.next;
            }
        }
        return head;
    }

}
