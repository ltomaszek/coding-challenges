package com.ltcode.solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 *
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */
public class _268_MissingNumber {
    /**
     * Using sum
     */
    public int missingNumber(int[] nums) {
        int expectedSum = (int) ((double)(0 + nums.length) / 2 * (nums.length + 1));
        int sum = IntStream.of(nums).reduce(0, (i, x) -> i + x);
        return expectedSum - sum;
    }

    /**
     * Using XOR
     */
    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= nums[i];
            missing ^= i;
        }
        return missing;
    }
}
