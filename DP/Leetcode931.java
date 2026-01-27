package DP;

import java.util.*;

public class Leetcode931 {

    // brute force tc is o(3^m*n), sc is o(n) only rows
    private int helper(int i, int j, int[][] arr) {
        int n = arr[0].length; // col

        // out of bounds
        if (j < 0 || j >= n)
            return Integer.MAX_VALUE;

        // base case: first row
        if (i == 0)
            return arr[0][j];

        int up = arr[i][j] + helper(i - 1, j, arr);
        int leftDiagonal = arr[i][j] + helper(i - 1, j - 1, arr);
        int rightDiagonal = arr[i][j] + helper(i - 1, j + 1, arr);

        return Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length; // row
        int n = matrix[0].length; // col

        int minSum = Integer.MAX_VALUE;

        // Try starting from each column in the last row
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, helper(m - 1, j, matrix));
        }

        return minSum;
    }

    private int helper2(int i, int j, int[][] arr, int[][] dp) {
        int n = arr[0].length; // col

        // out of bounds
        if (j < 0 || j >= n)
            return (int) 1e9; // big value

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // base case: first row
        if (i == 0)
            return arr[0][j];

        int up = arr[i][j] + helper2(i - 1, j, arr, dp);
        int leftDiagonal = arr[i][j] + helper2(i - 1, j - 1, arr, dp);
        int rightDiagonal = arr[i][j] + helper2(i - 1, j + 1, arr, dp);

        dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));

        return dp[i][j];
    }

    public int minFallingPathSum2(int[][] matrix) {
        int m = matrix.length; // row
        int n = matrix[0].length; // col

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int minSum = Integer.MAX_VALUE;

        // Try starting from each column in the last row
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, helper2(m - 1, j, matrix, dp));
        }

        return minSum;
    }

    // tabulation sol
    // tc is o(m * n) and sc is o(m * n) array
    public int minFallingPathSum3(int[][] matrix) {
        int m = matrix.length; // row
        int n = matrix[0].length; // col

        int[][] dp = new int[m][n];

        // base case: first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // fill the dp table row by row
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    leftDiagonal = matrix[i][j] + dp[i - 1][j - 1];
                }

                int rightDiagonal = Integer.MAX_VALUE;
                if (j + 1 < n) {
                    rightDiagonal = matrix[i][j] + dp[i - 1][j + 1];
                }

                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        // find minimum in the last row
        int minSum = dp[m - 1][0];
        for (int j = 1; j < n; j++) {
            minSum = Math.min(minSum, dp[m - 1][j]);
        }

        return minSum;
    }

    public static void main(String[] args) {

    }
}