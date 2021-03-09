package com.ltcode.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above.
 *
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */
public class _118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        if (numRows < 1)
            return output;
        output.add(getRowList(null));
        for (int i = 1; i < numRows; i++) {
            output.add(getRowList(output.get(i-1)));
        }
        return output;
    }

    private List<Integer> getRowList(List<Integer> prevList) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (prevList == null) {
            return list;
        }
        for (int i = 1; i < prevList.size(); i++) {
            int sum = prevList.get(i-1) + prevList.get(i);
            list.add(sum);
        }
        list.add(1);
        return list;
    }
}
