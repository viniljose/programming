package dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that the robot can take
 * to reach the bottom-right corner.
 * Input: m = 3, n = 7
 * Output: 28
 */
public class UniquePaths {

    //recursion
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1)
            return 1;
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }

    //DP o(m*n),o(m*n)
    public int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr,1);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] =dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
