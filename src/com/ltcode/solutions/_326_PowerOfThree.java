package com.ltcode.solutions;

/**
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 *
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 *
 * Input: n = 27
 * Output: true
 *
 * Input: n = 0
 * Output: false
 *
 * Input: n = 9
 * Output: true
 */
public class _326_PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;

        while (n % 3 == 0) {
            n = n/3;
        }
        return n == 1;
    }
}
