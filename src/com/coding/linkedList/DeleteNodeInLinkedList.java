package com.coding.linkedList;

import com.coding.linkedList.common.ListNode;
// Problem link : https://leetcode.com/problems/delete-node-in-a-linked-list/description/

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
