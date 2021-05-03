package com.ltcode.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _496_NextGreaterElement1Test {

    _496_NextGreaterElement1 instance;
    Object[][] data;

    @BeforeEach
    void setUp() {
        instance = new _496_NextGreaterElement1();
        data = new Object[][] {
                {new int[]{4,1,2}, new int[]{1,3,4,2}, new int[]{-1,3,-1}},
                {new int[]{2,4}, new int[]{1,2,3,4}, new int[]{3,-1}}
        };
    }

    @Test
    void nextGreaterElement() {
        for (Object[] d : data) {
            int[] nums1 = (int[]) d[0];
            int[] nums2 = (int[]) d[1];
            int[] expectedResult = (int[]) d[2];

            assertArrayEquals(expectedResult, instance.nextGreaterElement(nums1, nums2));
        }
    }
}