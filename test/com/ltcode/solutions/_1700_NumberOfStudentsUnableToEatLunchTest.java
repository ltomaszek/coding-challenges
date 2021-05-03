package com.ltcode.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _1700_NumberOfStudentsUnableToEatLunchTest {

    _1700_NumberOfStudentsUnableToEatLunch instance;
    Object[][] data;    // nums1[], nums2[], expectedOutput[]

    @BeforeEach
    void setUp() {
        instance = new _1700_NumberOfStudentsUnableToEatLunch();
        data = new Object[][] {
                {new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}, 0},
                {new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}, 3}
        };
    }

    @Test
    void countStudents() {
        for (Object[] d : data) {
            int[] students = (int[]) d[0];
            int[] sandwiches = (int[]) d[1];
            int expectedResult = (int) d[2];

            assertEquals(expectedResult, instance.countStudents(students, sandwiches));
        }
    }
}