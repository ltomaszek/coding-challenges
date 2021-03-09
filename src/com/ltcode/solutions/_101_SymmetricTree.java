package com.ltcode.solutions;

import com.ltcode.nodes.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class _101_SymmetricTree {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(null);
        queue.add(null);
        System.out.println(queue.size());
    }
    /**
     * Recursively solution
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null)
            return true;
        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val)
            return false;
        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }

    /**
     * Iteratively solution
     */
    public boolean isSymmetricIter(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>(); // LinkedList for readability purpose. ArrayDeque does not allow nulls
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null)
                continue;
            if (left == null || right == null || left.val != right.val)
                return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
