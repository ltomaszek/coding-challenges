package com.ltcode.solutions;

import java.util.*;
import java.util.stream.Collectors;

public class _496_NextGreaterElement1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Set<Integer> toCheck = Arrays
                .stream(nums1)
                .mapToObj(x -> x)
                .collect(Collectors.toCollection(() -> new HashSet<>()));
        Map<Integer, Integer> map = createNextGreaterElementMap(toCheck, nums2);
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    private Map<Integer, Integer> createNextGreaterElementMap(Set<Integer> mapKeys, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (mapKeys.contains(nums2[i])) {
                map.put(nums2[i], getNextGreaterElement(i, nums2));
            }
        }
        return map;
    }

    private int getNextGreaterElement(int fromExclude, int[] nums2) {
        for (int i = fromExclude + 1; i < nums2.length; i++) {
            if (nums2[fromExclude] < nums2[i])
                return nums2[i];
        }
        return -1;
    }
}
