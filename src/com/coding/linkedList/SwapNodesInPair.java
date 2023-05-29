package com.coding.linkedList;

import com.coding.linkedList.common.ListNode;

public class SwapNodesInPair {

//    --------------------  By Swapping Values --------------------
    public ListNode swapPairs(ListNode head) {
        // By swapping values
        if(head==null || head.next==null)
            return head;
        ListNode t1=head;
        ListNode t2=head.next;
        while(t2!=null)
        {
            int x=t1.val;
            t1.val=t2.val;
            t2.val=x;
            t1=t2.next;
            if(t1==null)
                break;
            else
                t2=t2.next.next;
        }
        return head;
    }

}
