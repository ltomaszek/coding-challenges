package com.ltcode.solutions;

import com.ltcode.nodes.ListNode;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class _206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode oldNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = oldNext;
        }
        return prev;
    }
}
