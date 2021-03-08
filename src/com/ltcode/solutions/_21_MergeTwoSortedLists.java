package com.ltcode.solutions;

import com.ltcode.nodes.ListNode;

/**
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 */
public class _21_MergeTwoSortedLists {

    /**
     * Creates new list with new nodes, the original ListNodes will not be modified
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tempRoot = new ListNode();
        ListNode currNode = tempRoot;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                currNode.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                currNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    currNode.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    currNode.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }
            currNode = currNode.next;
        }
        return tempRoot.next;
    }

    /**
     * Modifies existing original lists
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode tempRoot = new ListNode();
        ListNode currNode = tempRoot;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currNode.next = l1;
                l1 = l1.next;
            } else {
                currNode.next = l2;
                l2 = l2.next;
            }
            currNode = currNode.next;
        }
        if (l1 == null)
            currNode.next = l2;
        else
            currNode.next = l1;
        return tempRoot.next;
    }
}
