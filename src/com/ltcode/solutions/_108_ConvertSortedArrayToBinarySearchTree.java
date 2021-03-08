package com.ltcode.solutions;

import com.ltcode.nodes.TreeNode;

/**
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node
 * never differs by more than one.
 */
public class _108_Convert_Sorted_Array_To_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return createTree(nums, 0, nums.length);
    }

    private TreeNode createTree(int[] nums, int low, int high) {    // high exclusive
        if (low >= high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        return new TreeNode(
                nums[mid],
                createTree(nums, low, mid),
                createTree(nums, mid + 1, high)
        );
    }
}
