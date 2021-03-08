package com.ltcode.solutions;

/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */
public class _169_MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int counter = 0;

        for (int num : nums) {
            if (counter == 0)
                candidate = num;

            if (candidate == num)
                counter++;
            else
                counter--;
        }
        return candidate;
    }
}
