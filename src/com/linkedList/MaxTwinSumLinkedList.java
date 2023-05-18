package com.linkedList;

import com.linkedList.common.ListNode;
// Problem link: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
public class MaxTwinSumLinkedList {
    public ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode ahead=curr.next;
            curr.next=prev;
            prev=curr;
            curr=ahead;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode lst=reverse(slow);
        slow=head;
        int maxm=Integer.MIN_VALUE;
        while(lst!=null)
        {
            maxm=Math.max(maxm,lst.val+slow.val);
            slow=slow.next;
            lst=lst.next;
        }
        return maxm;

    }
}
