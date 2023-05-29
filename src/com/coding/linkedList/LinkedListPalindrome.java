package com.coding.linkedList;

import com.coding.linkedList.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// problem link : https://leetcode.com/problems/palindrome-linked-list/description/
public class LinkedListPalindrome {

    // ---------------------------- O(N) space ----------------------------------------
    public boolean isPalindrome1(ListNode head) {
        List<Integer> lst=new ArrayList();
        ListNode temp=head;
        while(temp!=null)
        {
            lst.add(temp.val);
            temp=temp.next;
        }
        Collections.reverse(lst);
        for(int i=0;i<lst.size();i++)
        {
            if(head.val!=lst.get(i))
                return false;
            head=head.next;
        }
        return true;

    }

    // ---------------------------- O(1) space ----------------------------------

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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode middle=slow;
        if(fast!=null)
            middle=middle.next;
        ListNode head2=reverse(middle);
        while(head!=null && head2!=null)
        {
            if(head.val!=head2.val)
                return false;
            head=head.next;
            head2=head2.next;
        }
        return true;
    }
}
