package com.ltcode.solutions;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class _242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        for (char c : sArr) {
            count[c-'a']++;
        }
        for (char c : tArr) {
            if (count[c-'a'] == 0)
                return false;
            count[c-'a']--;
        }
        return true;
    }
}
