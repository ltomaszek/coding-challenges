package com.ltcode.solutions;

import java.util.Arrays;
import java.util.Comparator;

public class _1710_Maximum_Units_OnA_Truck {

    /**
     * Slow version - using array sort
     */
    public int maximumUnitsUsingSort(int[][] boxTypes, int truckSize) {
        sortByUnitsPerBox(boxTypes);
        int units = 0;
        int boxIdx = 0;
        while (truckSize > 0 && boxIdx < boxTypes.length) {
            int numBoxesFromCurrType = Math.min(truckSize, boxTypes[boxIdx][0]);
            int unitsInOneBox = boxTypes[boxIdx][1];
            units += numBoxesFromCurrType * unitsInOneBox;
            truckSize -= numBoxesFromCurrType;
            boxIdx++;
        }
        return units;
    }

    /**
     * Fast version - using array sort
     */
    public int maximumUnitsUsingAdditionalArray(int[][] boxTypes, int truckSize) {
        int units = 0;
        // find box with max and min units
        int minUnits = Integer.MAX_VALUE;
        int maxUnits = 0;
        for (int[] boxType : boxTypes) {
            int unitsInBox = boxType[1];
            minUnits = Math.min(minUnits, unitsInBox);
            maxUnits = Math.max(maxUnits, unitsInBox);
        }

        // create array with weights
        int[] unitsToNumBoxes = new int[maxUnits - minUnits + 1];  // int[5] = 7 means that there are 7 boxes with (5 + minUnits) units in each
        for (int[] boxType : boxTypes) {
            int numBoxes = boxType[0];
            int unitsInBox = boxType[1];
            unitsToNumBoxes[unitsInBox - minUnits] += numBoxes;
        }

        // calculate total units that can be loaded on the truck
        for (int i = unitsToNumBoxes.length - 1; i >= 0; i--) {
            int numBoxes = unitsToNumBoxes[i];
            if (numBoxes == 0)
                continue;
            int numBoxesToUse = Math.min(truckSize, numBoxes);
            int weight = i + minUnits;
            units += numBoxesToUse * weight;
            truckSize -= numBoxesToUse;
            if (truckSize == 0)
                break;
        }
        return units;
    }

    private void sortByUnitsPerBox(int[][] boxTypes) {
        Arrays.sort(boxTypes, (b1, b2) -> {
            return Comparator.comparing((int[] x) -> x[1]).reversed().compare(b1, b2);
        });
    }
}
