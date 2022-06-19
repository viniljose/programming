package dp;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 * Input: cost = [10,15,20] Output: 15
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length+1];

        for (int i = 2; i < dp.length; i++) {
            int oneStep = dp[i-1]+cost[i-1];
            int twoStep = dp[i-2]+cost[i-2];
            dp[i] = Math.min(oneStep,twoStep);
        }
        return dp[dp.length-1];
    }
}
