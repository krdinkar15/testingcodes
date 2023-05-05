package com.linkedList;

import com.linkedList.common.ListNode;
// problem link : https://leetcode.com/problems/merge-two-sorted-lists/description/
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null)
            return null;
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode ans=new ListNode(0);
        ListNode lst=ans;
        while(list1!=null && list2!=null)
        {
            if(list1.val<=list2.val)
            {
                lst.next=list1;
                list1=list1.next;
            }
            else
            {
                lst.next=list2;
                list2=list2.next;
            }
            lst=lst.next;
        }
        if(list1!=null)
            lst.next=list1;
        else
            lst.next=list2;
        return ans.next;
    }
}
