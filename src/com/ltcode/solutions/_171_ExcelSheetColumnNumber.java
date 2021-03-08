package com.ltcode.solutions;

import org.w3c.dom.ls.LSOutput;

/**
 * Given a string columnTitle that represents the column title as appear in an Excel sheet,
 * return its corresponding column number.
 *
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 */
public class _171_ExcelSheetColumnNumber {
    /**
     * 1st solution
     */
    public int titleToNumber(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res = res * 26 + (letterToNumber(s.charAt(i)));
        }
        return res;
    }

    /**
     * 2nd solution
     */
    public int titleToNumber2(String columnTitle) {
        int N = columnTitle.length();
        int result = 0;
        for (int i = N - 1; i >= 0; i--) {
            int letterNumber = letterToNumber(columnTitle.charAt(N - 1 - i));
            result += Math.pow(26, i) * letterNumber;
        }
        return result;
    }

    private int letterToNumber(char letter) {
        return letter - 'A' + 1;
    }
}
