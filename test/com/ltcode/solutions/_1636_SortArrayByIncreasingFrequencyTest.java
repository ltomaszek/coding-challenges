package com.ltcode.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _1636_SortArrayByIncreasingFrequencyTest {

    _1636_SortArrayByIncreasingFrequency instance;
    Object[][] data;    // nums[], expectedOutput[]

    @BeforeEach
    void setUp() {
        instance = new _1636_SortArrayByIncreasingFrequency();
        data = new Object[][] {
                {new int[]{1,1,2,2,2,3}, new int[]{3,1,1,2,2,2}},
                {new int[]{2,3,1,3,2}, new int[]{1,3,3,2,2}},
                {new int[]{-1,1,-6,4,5,-6,1,4,1}, new int[]{5,-1,4,4,-6,-6,1,1,1}}
        };
    }

    @Test
    void frequencySort() {
        for (Object[] d : data) {
            int[] nums = (int[]) d[0];
            int[] expectedResult = (int[]) d[1];

            assertArrayEquals(expectedResult, instance.frequencySort(nums));
        }
    }
}