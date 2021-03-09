package com.ltcode.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class _70_ClimbingStairs {

    private List<Integer> list = new ArrayList<>() {
        {
            add(0);
            add(1);
            add(2);
        }
    };

    public int climbStairs(int n) {
        if (n < 0) return 0;
        if (n < list.size())
            return list.get(n);

        int result = climbStairs(n - 1) + climbStairs(n - 2);
        list.add(result);
        return result;
    }
}
