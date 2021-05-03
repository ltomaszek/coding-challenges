package com.ltcode.chapters.binary_tree.pre_in_post_order_traversal;

import com.ltcode.binary_tree.BinaryTrees;
import com.ltcode.binary_tree.Node;
import java.util.*;

public class BinaryTreeUtils {

    private static final Node<Integer> root = BinaryTrees.getNewBinaryTree(new Integer[] {1,2,3, null, 5, 2, null, 7});
    private static final Node<Integer> mirrorRoot = BinaryTrees.getNewBinaryTree(new Integer[] {1,2,2,3,4,4,3});

    public static void main(String[] args) {
        // Given a binary tree, return the preorder traversal of its nodes' values.
        // Follow up: Recursive solution is trivial, could you do it iteratively?
        preorderTraversal();
        System.out.println();

        // Given a binary tree, return the inorder traversal of its nodes' values.
        // Follow up: Recursive solution is trivial, could you do it iteratively?
        inorderTraversal();
        System.out.println();

        // Given the root of a binary tree, return the postorder traversal of its nodes' values.
        // Follow up: Recursive solution is trivial, could you do it iteratively?
        postorderTraversal();
        System.out.println();

        // Given a binary tree, return the level order traversal of its nodes' values.
        // (ie, from left to right, level by level).
        levelorderTraversal();
        System.out.println();

        // RECURSION

        // We can solve a tree problem recursively using a top-down approach or using a bottom-up approach

        // Given a binary tree, find its maximum depth.
        // The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
        maximumDepthOfBinaryTree();
        System.out.println();

        // Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
        // For example, this binary tree [1,2,2,3,4,4,3] is symmetric
        symmetricTree();
        System.out.println();

        // Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up
        // all the values along the path equals the given sum.
        pathSum();
        System.out.println();

    }

    public static void preorderTraversal() {
        List<Integer> valList = new ArrayList<>();

        // preorder traversal
        ArrayDeque<Node<Integer>> deque = new ArrayDeque<>();
        Node<Integer> currNode = root;

        while (currNode != null || !deque.isEmpty()) {
            while (currNode != null) {
                deque.push(currNode);
                valList.add(currNode.val);
                currNode = currNode.left;
            }

            currNode = deque.poll();
            currNode = currNode.right;
        }

        System.out.println(valList);
    }

    public static void inorderTraversal() {
        List<Integer> valList = new ArrayList<>();

        // preorder traversal
        ArrayDeque<Node<Integer>> deque = new ArrayDeque<>();
        Node<Integer> currNode = root;

        while (currNode != null || !deque.isEmpty()) {
            while (currNode != null) {
                deque.push(currNode);
                currNode = currNode.left;
            }

            currNode = deque.poll();
            valList.add(currNode.val);
            currNode = currNode.right;
        }

        System.out.println(valList);
    }

    public static void postorderTraversal() {
        List<Integer> valList = new ArrayList<>();

        // preorder traversal
        ArrayDeque<Node<Integer>> deque = new ArrayDeque<>();
        Node<Integer> currNode = root;
        Set<Node<Integer>> visited = new HashSet<>();

        while (currNode != null || !deque.isEmpty()) {
            while (currNode != null) {
                deque.push(currNode);
                currNode = currNode.left;
            }

            currNode = deque.peek();            // peekfirst
            if (visited.contains(currNode)) {
                valList.add(currNode.val);
                visited.remove(currNode);
                deque.poll();                   // remove from deque
                currNode = null;
            } else {
                visited.add(currNode);
                currNode = currNode.right;
            }
        }

        System.out.println(valList);
    }

    public static void levelorderTraversal() {
        // list of level's values
        List<List<Integer>> list = new ArrayList<>();

        ArrayDeque<Node<Integer>> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> levelList = new ArrayList<>();

            while (size > 0) {
                Node<Integer> currNode = deque.poll();
                levelList.add(currNode.val);

                // add children to deque
                if (currNode.left != null) deque.offer(currNode.left);
                if (currNode.right != null) deque.offer(currNode.right);
                size--;
            }

            // add level list to end list
            list.add(levelList);
        }

        // print result
        System.out.println(list);
    }

    public static void maximumDepthOfBinaryTree() {
        int maxDepth = maxDepth(root);
        System.out.println("Maximum depth of binary tree: " + maxDepth);
    }

    public static void symmetricTree() {
        boolean isSymmetric = mirrorRoot == null ? true : isSymmetric(mirrorRoot.left, mirrorRoot.right);
        System.out.println("Is tree symmetric: " + isSymmetric);
    }

    public static void pathSum() {
        int targetSum = 6;
        boolean hasPathSum = hasPathSum(root, targetSum);
        System.out.println("Has path sum: " + hasPathSum);
    }

    // helper functions
    private static int maxDepth(Node node) {
        if (node == null)
            return 0;

        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    private static boolean isSymmetric(Node node1, Node node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null || !node1.val.equals(node2.val)) return false;
        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }

    /** ORGINALLY: private static boolean hasPathSum(Node<Integer> node, int targetSum, int currentSum)
     *  NEW method declaration - use targetSum to subract level value! no need to keep truck of 'all levels sum'
    */
    private static boolean hasPathSum(Node<Integer> node, int targetSum) {
        if (node == null) return false;
        if (node.left == null && node.right == null) return targetSum == node.val;

        targetSum = targetSum - node.val;
        return hasPathSum(node.left, targetSum) || hasPathSum(node.right, targetSum);
    }
}
