package com.ltcode.solutions.challenges;


/**
 * Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement:
 * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 *
 * If there are multiple answers, print any of them.
 *
 * Example 1:
 * Input: n = 3, k = 1
 * Output: [1, 2, 3]
 * Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.
 *
 * Example 2:
 * Input: n = 3, k = 2
 * Output: [1, 3, 2]
 *
 * Solution:
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 7 6
 * 1 2 3 4 7 5 6
 * 1 2 3 7 4 6 5
 * 1 2 7 3 6 4 5
 * 1 7 2 6 3 5 4
 * 7 1 6 2 5 3 4
 */
public class BeautifulArrangement2 {

    /** Slow solution */
    public int[] constructArray(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        int swapIdx = n - 1;
        while(k-- > 1) {
            int currSwapIdx = swapIdx;
            while (currSwapIdx < n) {
                swap(arr, currSwapIdx - 1, currSwapIdx);
                currSwapIdx += 2;
            }
            swapIdx--;
        }

        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /** Fast solution */
    public int[] constructArray2(int n, int k) {
        int[] arr = new int[n];

        int rightIdx = n - k;
        for(int i = 0; i < rightIdx; i++) {
            arr[i] = i + 1;
        }

        arr[rightIdx] = n;
        for (int i = rightIdx + 1, sign = -1; i < n; i++) {
            k--;
            arr[i] = arr[i-1] + (sign * k);
            sign *= -1;
        }

        return arr;
    }
}
