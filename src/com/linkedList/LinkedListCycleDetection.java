package com.linkedList;

import com.linkedList.common.ListNode;
// Problem link : https://leetcode.com/problems/linked-list-cycle/description/
public class LinkedListCycleDetection {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;

    }
}
