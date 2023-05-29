package com.coding.linkedList;

import com.coding.linkedList.common.ListNode;

// Problem link : https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers
{

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode head = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int t = l1.val + l2.val + carry;
            carry = (t >= 10 )? 1 : 0;
            t = t % 10;
            ans.next = new ListNode(t);
            ans = ans.next;
            if (head == null)
                head = ans;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int t = l1.val + carry;
            carry = (t >= 10) ? 1 : 0;
            t = t % 10;
            ans.next = new ListNode(t);
            ans = ans.next;
            if (head == null)
                head = ans;
            l1 = l1.next;
        }
        while (l2 != null) {
            int t = l2.val + carry;
            carry = (t >= 10) ? 1 : 0;
            t = t % 10;
            ans.next = new ListNode(t);
            ans = ans.next;
            if (head == null)
                head = ans;
            l2 = l2.next;
        }
        if (carry == 1) {
            ans.next = new ListNode(1);
            if (head == null)
                head = ans;
            ans = ans.next;
        }
        return head;

    }

    public static void main(String[] args)
    {
        ListNode l1=new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
        ListNode l2=new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));
        ListNode ans=addTwoNumbers(l1,l2);
        while(ans!=null)
        {
            System.out.print(ans.val+" ");
            ans=ans.next;
        }
    }
}