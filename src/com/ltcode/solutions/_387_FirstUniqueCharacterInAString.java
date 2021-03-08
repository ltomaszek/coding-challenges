package com.ltcode.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;

/**
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 */
public class _387_FirstUniqueCharacterInAString {
    /**
     * 1 ms
     */
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0)
            return -1;

        int result = s.length();

        for(char c = 'a'; c <= 'z'; c++) {
            int firstIdx = s.indexOf(c);
            if(firstIdx != -1 && firstIdx == s.lastIndexOf(c))
                result = Math.min(result, firstIdx);
        }
        return result == s.length()? -1 : result;
    }

    /**
     * 20 ms
     */
    public int firstUniqChar2(String s) {
        Map<Character, Byte> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (map.get(ch) == null) {
                map.put(ch, (byte)1);
            } else {
                map.put(ch, (byte)2);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
