package com.ltcode.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */
public class _217_Contains_Duplicate {
    /**
     * Using HashSet
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }

    /**
     * Using sort
     */
    public boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1 ; i < nums.length; i++){
            if(nums[i-1] == nums[i])
                return true;
        }
        return false;
    }
}
