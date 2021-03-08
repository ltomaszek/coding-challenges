package com.ltcode.solutions;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 */

public class _344_ReverseString {
    public void reverseString(char[] s) {
        for (int leftIdx = 0; leftIdx < s.length / 2; leftIdx++) {
            int rightIdx = s.length - 1 - leftIdx;
            char temp = s[leftIdx];
            s[leftIdx] = s[rightIdx];
            s[rightIdx] = temp;
        }
    }
}
