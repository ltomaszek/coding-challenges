package com.ltcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class _13_RomanToInteger {

    private Map<Character, Integer> map = new HashMap<>(7) {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int romanToInt(String s) {
        int result = 0;
        int prevValue = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int currVal = letterToInt(ch);

            if (currVal > prevValue) {
                result -= 2 * prevValue;
            }
            result += currVal;
            prevValue = currVal;
        }
        return result;
    }

    public int letterToInt(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }
}
