package com.leetcode.classes;

public class ListNode {
    public int data;
    public ListNode next;
    ListNode()
    {}
    ListNode(int data)
    {
        this.data=data;
    }
    ListNode(int val, ListNode next)
    {
        this.data=val;
        this.next=next;
    }
}
