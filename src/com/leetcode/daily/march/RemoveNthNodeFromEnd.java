package com.leetcode.daily.march;

import com.coding.linkedList.common.ListNode;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode temp=head;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        int toRemove=count-n+1;
        temp=head;
        ListNode prev=null;
        for(int i=1;i<toRemove;i++)
        {
            prev=temp;
            temp=temp.next;
        }
        if(prev==null)
        {
            return head.next;
        }
        else
        {
            prev.next=temp.next;
        }
        return head;
    }
    public ListNode removeNthFromEndOnePass(ListNode head, int n) {
        ListNode start=head;
        ListNode end=head;
        for(int i=0;i<n;i++)
        {
            end=end.next;
        }
        if(end==null)
            return head.next;

        while(end.next!=null)
        {
            start=start.next;
            end=end.next;
        }
        start.next=start.next.next;
        return head;

    }
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        listNode.next.next.next.next=new ListNode(5);

        RemoveNthNodeFromEnd removeNthNodeFromEnd=new RemoveNthNodeFromEnd();
        ListNode ans=removeNthNodeFromEnd.removeNthFromEnd(listNode,2);
        ListNode ans2=removeNthNodeFromEnd.removeNthFromEndOnePass(listNode,2);
        System.out.println(ans2);
    }
}
