package com.ltcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 */
public class _350_IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0;
        int i2 = 0;

        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                intersection.add(nums1[i1]);
                i1++;
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1 = indexOfNextValue(nums1, i1 + 1);       // or i++;
            } else {
                i2 = indexOfNextValue(nums2, i2 + 1);       // or j++
            }
        }
        return intersection.stream().mapToInt(x -> x).toArray();
    }

    private int indexOfNextValue(int[] arr, int fromIdx) {
        for (int i = fromIdx; i < arr.length; i++) {
            if (arr[i-1] != arr[i])
                return i;
        }
        return arr.length;
    }
}
