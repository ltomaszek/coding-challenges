package com.ltcode.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 *
 * Example 1:
 *
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class _202_HappyNumber {

    private Set<Integer> seenNumbers = new HashSet<>();

    /**
     * Using HashSet
     */
    public boolean isHappy(int n) {
        if (n == 1)
            return true;
        if (seenNumbers.contains(n))
            return false;
        seenNumbers.add(n);
        int sumOfSqrDigits = getSumOfSqrDigits(n);
        return isHappy(sumOfSqrDigits);
    }

    /**
     * Using fast and slow runner
     */
    public boolean isHappy2(int n) {
        if(n <= 0)
            return false;
        int slow = n, fast = n;
        do {
            slow = getSumOfSqrDigits(slow);
            fast = getSumOfSqrDigits(fast);
            fast = getSumOfSqrDigits(fast);
            if (fast == 1)
                return true;
        } while(slow != fast);
        return false;
    }

    private int getSumOfSqrDigits(int n) {
        int sumOfSqrDigits = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            sumOfSqrDigits += digit * digit;
        }
        return sumOfSqrDigits;
    }
}
