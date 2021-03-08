package com.ltcode.solutions;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class _283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i = nextZero(nums, 0);
        int j = nextNoneZero(nums, i + 1);
        while (j<nums.length) {
            nums[i]=nums[j];
            nums[j]=0;
            i=i+1;                  // i+1 will always be 0
            j=nextNoneZero(nums,j);
        }
    }

    /**
     * Returns next index of '0' or the length of nums
     */
    private int nextZero(int[] nums, int i) {
        while (i<nums.length && nums[i]!=0) {
            i++;
        }
        return i;
    }

    private int nextNoneZero(int[] nums, int i) {
        while (i<nums.length && nums[i]==0) {
            i++;
        }
        return i;
    }
}
