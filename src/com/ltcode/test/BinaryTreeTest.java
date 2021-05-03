package com.ltcode.test;

import com.ltcode.binary_tree.BinaryTrees;
import com.ltcode.binary_tree.Node;

/**
 *  TEST:
 *  - creating new BinaryTree
 *  BinaryTrees.getNewBinaryTree(Object[])
 *  - printing Tree for visual purpose
 *  BinaryTrees.printTree(Node)
 */
public class BinaryTreeTest {

    Node root;

    public static void main(String[] args) {
        new BinaryTreeTest().test();
    }

    public void test() {
        // create new binary tree
        Integer[] integerTree = {1, 2, 3, null, 5, 6, 7, null, 8};
        Node root = BinaryTrees.getNewBinaryTree(integerTree);

        // print tree
        root.printTree();
    }
}
