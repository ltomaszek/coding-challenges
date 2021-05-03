package com.ltcode.time_complexity;

import java.security.SecureRandom;
import java.util.*;

/**
 * Check which list will complete the work faster when using insert at random positions
 *
 * Challenge:
 * 1389. Create Target Array in the Given Order

 * Share
 * Given two arrays of integers nums and index. Your task is to create target array under the following rules:
 *
 * Initially target array is empty.
 * From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 * Repeat the previous step until there are no elements to read in nums and index.
 * Return the target array.
 *
 * It is guaranteed that the insertion operations will be valid.

 * Example 1:
 *
 * Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * Output: [0,4,1,3,2]
 */
public class ArrayListXLinkedList {

    public static void main(String[] args) {
        int size = 100_000;

        int[] nums = new int[size];
        int[] index = new int[size];
        createIndexes(index);

        testTime(nums, index);
    }

    private static void testTime(int[] nums, int[] index) {
        long time;
        Solution.ListType listType;

        System.out.println("\t ====== TEST TIME / SIZE = " + nums.length + " =====");

        listType = Solution.ListType.ARRAY_LIST;
        time = testTime(nums, index, listType);
        System.out.printf("%-15s%d\n", listType, time);

        listType = Solution.ListType.LINKED_LIST;
        time = testTime(nums, index, Solution.ListType.LINKED_LIST);
        System.out.printf("%-15s%d\n", listType, time);
    }

    private static long testTime(int[] nums, int[] index, Solution.ListType listType) {
        long timeStart;
        long timeEnd;

        timeStart = System.currentTimeMillis();
        new Solution().createTargetArray(nums, index, listType);
        timeEnd = System.currentTimeMillis();
        return timeEnd - timeStart;
    }

    private static void createIndexes(int[] arr) {
        // arr[i] <= i
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(i + 1);
        }
    }


}

class Solution {
    enum ListType {
        ARRAY_LIST, LINKED_LIST;
    }

    public int[] createTargetArray(int[] nums, int[] index, ListType listType) {
        List<Integer> list;
        switch (listType) {
            case ARRAY_LIST:
                list = new ArrayList<>();
                break;
            case LINKED_LIST:
                list = new LinkedList<>();
                break;
            default:
                throw new IllegalArgumentException();
        }

        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        int[] results = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            results[i] = list.get(i);
        }

        return results;
    }
}
