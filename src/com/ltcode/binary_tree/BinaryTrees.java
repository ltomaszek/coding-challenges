package com.ltcode.binary_tree;

import java.util.ArrayDeque;

public class BinaryTrees {

    public static void printTree(Node root) {
        if (root == null) {
            System.out.println(root);
            return;
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                Node currNode = queue.poll();
                System.out.print(currNode);
                System.out.print("   ");

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);

                size--;
            }
            System.out.println();
        }
    }

    // FACTORY METHODS

    public static Node getNewBinaryTree(Object[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        ArrayDeque<Node> queue = new ArrayDeque<>();
        Node root = new Node(arr[0]);
        queue.offer(root);

        int ix = 1;
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            // left side
            if (ix < arr.length && arr[ix] != null) {
                currNode.left = new Node(arr[ix]);
                //add new node to queue
                queue.offer(currNode.left);
            }
            ix++;

            // right side
            if (ix < arr.length && arr[ix] != null) {
                currNode.right = new Node(arr[ix]);
                //add new node to queue
                queue.offer(currNode.right);
            }
            ix++;
        }

        return root;
    }
}
