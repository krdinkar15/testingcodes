package com.coding.linkedList;


import com.coding.linkedList.common.ListNode;

import java.util.HashSet;
import java.util.Set;
// Problem link : https://leetcode.com/problems/intersection-of-two-linked-lists/description/
public class IntersectionLinkedList {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> hs=new HashSet<>();
        while(headA!=null)
        {
            hs.add(headA);
            headA=headA.next;
        }
        while(headB!=null)
        {
            if(hs.contains(headB))
                return headB;
            headB=headB.next;
        }
        return null;
    }


    // O(1) space and O(n) Time
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode first=headA;
        ListNode second=headB;
        while(first!=second) // If no loop they will point to null
        {
            if(first==null)
                first=headB;
            else
                first=first.next;
            if(second==null)
                second=headA;
            else
                second=second.next;
        }
        return first;
    }
}
