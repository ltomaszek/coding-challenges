package com.ltcode.solutions.challenges;

import java.util.Arrays;

public class LongestIncreasingPathInAMatrix {

    private int longestLength = 0;
    private int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int[][] matrixCopy = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            matrixCopy[i] = Arrays.copyOfRange(matrix[i], 0, matrix[i].length);
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                findIncresingPath(matrixCopy, r, c, -1, 0);
            }
        }

        return longestLength;
    }

    public void findIncresingPath(int[][] matrix, int r, int c, int prevValue, int pathLength) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length
                || matrix[r][c] == -1
                || prevValue >= matrix[r][c]) {
            longestLength = Math.max(longestLength, pathLength);
            return;
        }

        int originalValue = matrix[r][c];
        matrix[r][c] = -1;

        for (int[] delta : deltas) {
            findIncresingPath(matrix, r + delta[0], c + delta[1], originalValue, pathLength + 1);
        }
        matrix[r][c] = originalValue;
    }
}
