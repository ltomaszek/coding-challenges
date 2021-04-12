package com.ltcode.solutions.challenges;

import com.ltcode.nodes.TreeNode;

/**
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 *
 * Example 2:
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 19
 */
public class DeepestLeavesSum {

    private int maxDepth = 0;
    private int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;
        deepestLeavesSum(root, 0);
        return sum;
    }

    private void deepestLeavesSum(TreeNode node, int level) {
        if (node.left != null)
            deepestLeavesSum(node.left, level + 1);
        if (node.right != null)
            deepestLeavesSum(node.right, level + 1);
        if (node.left == null && node.right == null) {
            if (level > maxDepth) {
                maxDepth = level;
                sum = node.val;
            } else if (level == maxDepth) {
                sum += node.val;
            }
        }
    }
}
