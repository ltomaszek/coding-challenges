package com.ltcode.binary_tree;

public class Node<T> {
    public T val;
    public Node<T> left;
    public Node<T> right;

    public Node(T val) {
        this.val = val;
    }

    public void printTree() {
        BinaryTrees.printTree(this);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(val)
                .append(" (")
                .append(left == null ? "null" : left.val)
                .append("|")
                .append(right == null ? "null" : right.val)
                .append(")")
                .toString();
    }
}
