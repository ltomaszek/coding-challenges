package com.ltcode.solutions;

import java.util.Arrays;
import java.util.Comparator;

public class _1636_SortArrayByIncreasingFrequency {

    private final int SHIFT = 100;
    private int uniqueNumbers = 0;

    public int[] frequencySort2(int[] nums) {
        int[] counter = getFrequencies(nums); // 0 -> -100, 1, -99
        int[][] numAndFreq = getNumAndFreq(counter); // {[num1, freq], [num2, freq], ...}
        // sort by frequency asc, desc if more the same frequencies
        Arrays.sort(numAndFreq, getSortComparator());
        // create final array
        int[] result = new int[nums.length];
        int idx = 0;
        for (int[] a : numAndFreq) {
            int num = a[0];
            int freq = a[1];
            Arrays.fill(result, idx, idx + freq, num);
            idx += freq;
        }
        return result;
    }

    private int[] getFrequencies(int[] nums) {
        uniqueNumbers = 0;
        int[] counter = new int[201]; // 0 -> -100, 1, -99
        for (int num : nums) {
            if (counter[num + SHIFT] == 0)
                uniqueNumbers++;
            counter[num + SHIFT]++;
        }
        return counter;
    }

    private int[][] getNumAndFreq(int[] counter) {
        int[][] numAndFreq = new int[uniqueNumbers][2];
        int arrIdx = 0;
        for (int i = 0; i < counter.length; i++) {
            int freq = counter[i];
            if (freq > 0) {
                int num = i - SHIFT;
                numAndFreq[arrIdx++] = new int[] {num, freq};
            }
        }
        return numAndFreq;
    }

    private Comparator<int[]> getSortComparator() {
        return new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1])
                    return -1;
                else if (o1[1] > o2[1])
                    return 1;
                return o2[0] < o1[0] ? -1 : 1;
            }
        };
    }

    /** Fast not my solution */
    public int[] frequencySort(int[] nums) {
        int[] cnts = new int[201];
        for (int n : nums) {
            cnts[n + 100]++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 201 * cnts[nums[i] + 100] - nums[i] + 100;
            System.out.print(nums[i]+" ");
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 100 - nums[i] % 201;
        }
        return nums;
    }
}
