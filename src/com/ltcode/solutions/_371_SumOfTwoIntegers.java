package com.ltcode.solutions;

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 */
public class _371_SumOfTwoIntegers {

    /**
     * sum = 8
     * 1 1 0
     * 0 1 0
     * => XOR = 4, AND = 2, sum = XOR + AND << 1
     * 1 0 0
     * 1 0 0
     * => XOR = 0, AND = 8
     *   0 0 0
     * 1 0 0 0
     * = > XOR = 8, AND = 0     END return XOR
     */
    public int getSum(int a, int b) {
        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
