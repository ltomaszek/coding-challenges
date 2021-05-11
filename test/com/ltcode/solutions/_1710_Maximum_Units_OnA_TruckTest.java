package com.ltcode.solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _1710_Maximum_Units_OnA_TruckTest {

    _1710_Maximum_Units_OnA_Truck instance;
    Object[][] data;    // int[][] boxTypes, truckSize, expectedOutput

    @BeforeEach
    void setUp() {
        instance = new _1710_Maximum_Units_OnA_Truck();
        data = new Object[][] {
                {new int[][]{{1,3},{2,2},{3,1}}, 4, 8},
                {new int[][]{{5,10},{2,5},{4,7},{3,9}}, 10, 91},
                {new int[][]{{1,1}}, 10, 1},
        };
    }

    @Test
    void testMaximumUnitsUsingSort() {
        for (Object[] d : data) {
            int[][] boxTypes = (int[][]) d[0];
            int truckSize = (int) d[1];
            int expectedOutput = (int) d[2];

            assertEquals(expectedOutput, instance.maximumUnitsUsingSort(boxTypes, truckSize));
        }
    }

    @Test
    void testMaximumUnitsUsingAdditionalArray() {
        for (Object[] d : data) {
            int[][] boxTypes = (int[][]) d[0];
            int truckSize = (int) d[1];
            int expectedOutput = (int) d[2];

            assertEquals(expectedOutput, instance.maximumUnitsUsingAdditionalArray(boxTypes, truckSize));
        }
    }

    @Test
    void testPerformance() {
        int[][] boxTypes = {{10, 350}, {2, 600}, {10, 350}, {2, 600}, {10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600}, {10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600},{10, 350}, {2, 600}};
        int truckSize = 950;
        Runnable sortMethod = () -> instance.maximumUnitsUsingSort(boxTypes, truckSize);
        Runnable arrayMethod = () -> instance.maximumUnitsUsingAdditionalArray(boxTypes, truckSize);
        int REPEATS = 100_000;
        long runtimeSort = getRuntime(sortMethod, REPEATS);
        long runtimeArray = getRuntime(arrayMethod, REPEATS);

        System.out.println("Sort method runtime  : " + Math.round(runtimeSort * 1e-6));
        System.out.println("Array method runtime : " + Math.round(runtimeArray * 1e-6));
    }

    private long getRuntime(Runnable r, int REPEATS) {
        long startTime = System.nanoTime();
        for (int i = 0; i < REPEATS; i++) {
            r.run();
        }
        return System.nanoTime() - startTime;
    }
}