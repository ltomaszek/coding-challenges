package com.ltcode.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.ritambhara.in/maximum-xor-value-of-two-elements/
 */
public class MaximumXORofTwoNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString("abc.de".split("\\.")));
        List<Integer> l = new ArrayList<>();
        l.add(0, 40);
        System.out.println(l);

        String s = null;
        //s.split('.');
        System.out.println(Integer.MAX_VALUE >> 31);
        StringBuilder sb = new StringBuilder();
        System.out.println("sb= " + sb);
        int[] numbers = {3, 10, 5, 25, 2, 8};
        int maxXor = new MaximumXORofTwoNumbers().find(numbers);
        System.out.println(maxXor);
    }

    /**
     * brute force - O(n^2)
     * linear time - use binary tree
     */
    public int find(int[] numbers) {
        // create binary tree of all numbers (their bits)
        TreeNode root = new TreeNode();
        createTree(root, numbers);

        int maxXor = findMaxXor(root, numbers);

        return maxXor;
    }

    private void createTree(TreeNode root, int[] numbers) {
        for (int number : numbers)
            addNumberToTreeImproved(root, number);
    }

    private void addNumberToTree(TreeNode root, int number) {
        // each number has 32 bits
        String binaryStr = Integer.toBinaryString(number);
        int leadingZeros = 32 - binaryStr.length();
        TreeNode currNode = root;

        // push leading zeros
        while (leadingZeros > 0) {
            if (currNode.left == null)
                currNode.left = new TreeNode();
            currNode = currNode.left;
            leadingZeros--;
        }
        // push rest of number
        for (int i = 0; i < binaryStr.length(); i++) {
            char binaryChar = binaryStr.charAt(i);
            if (binaryChar == '0') {
                if (currNode.left == null)
                    currNode.left = new TreeNode();
                currNode = currNode.left;
            } else {
                if (currNode.right == null)
                    currNode.right = new TreeNode();
                currNode = currNode.right;
            }
        }
    }

    private void addNumberToTreeImproved(TreeNode root, int number) {
        TreeNode currNode = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (number >> i) & 1;
            if (bit == 1) {
                if (currNode.right == null)
                    currNode.right = new TreeNode();
                currNode = currNode.right;
            } else {
                if (currNode.left == null)
                    currNode.left = new TreeNode();
                currNode = currNode.left;
            }

        }
    }

    private int findMaxXor(TreeNode root, int[] numbers) {
        StringBuilder maxXor = new StringBuilder();
        maxXor.append("00000000000000000000000000000000");

        for (int number : numbers) {
            StringBuilder bitDiff = new StringBuilder();
            String binaryStr = Integer.toBinaryString(number);
            int leadingZeros = 32 - binaryStr.length();
            int totalIx = 0;
            boolean needToCompare = true;

            TreeNode currNode = root;
            // for leadingZeros
            while (leadingZeros > 0) {

                if (currNode.right != null) {
                    bitDiff.append("1");
                    currNode = currNode.right;
                } else {
                    bitDiff.append("0");
                    currNode = currNode.left;
                }

                // compare with maxDiff so far
                if (needToCompare) {
                    if (maxXor.charAt(totalIx) == '1' && bitDiff.charAt(totalIx) == '0')
                        break;
                    // new best
                    if (maxXor.charAt(totalIx) == '0' && bitDiff.charAt(totalIx) == '1')
                        needToCompare = false;
                }

                leadingZeros--;
                totalIx++;
            }
            // for number
            for (int i = 0; i < binaryStr.length(); i++) {
                char binaryChar = binaryStr.charAt(i);
                if (binaryChar == '0') {
                    if (currNode.right != null) {
                        bitDiff.append("1");
                        currNode = currNode.right;
                    } else {
                        bitDiff.append("0");
                        currNode = currNode.left;
                    }
                } else {
                    // for '1'
                    if (currNode.left != null) {
                        bitDiff.append("1");
                        currNode = currNode.left;
                    } else {
                        bitDiff.append("0");
                        currNode = currNode.right;
                    }
                }

                // compare with maxDiff so far
                if (needToCompare) {
                    if (maxXor.charAt(totalIx) == '1' && bitDiff.charAt(totalIx) == '0')
                        break;
                    // new best
                    if (maxXor.charAt(totalIx) == '0' && bitDiff.charAt(totalIx) == '1')
                        needToCompare = false;
                }

                totalIx++;
            }

            // new bitDiff is
            if (totalIx == 32)
                maxXor = bitDiff;
        }

        int result = 0;
        for (int i = 0; i < maxXor.length(); i++) {
            result = result << 1;
            result += maxXor.charAt(i) - '0';
        }

        return result;
    }

    private class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}
