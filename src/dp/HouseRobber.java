package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/house-robber/
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them
 * is that adjacent houses have security systems connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 * Input: nums = [1,2,3,1] Output: 4
 */
public class HouseRobber {
    private Map<Integer,Integer> memo = new HashMap<>();
    private int[] nums;

    public int rob(int[] nums) {
        nums = nums;
        return dp(nums.length-1);
    }

    //Top down with recursion and memoization
    private int dp(int i){
        if(i==0)
            return nums[0];
        if(i==1)
            return Math.max(nums[0],nums[1]);
        if(!memo.containsKey(i)){
            memo.put(i,Math.max(dp(i-1),dp(i-2))+nums[i]);
        }
        return nums[i];
    }

    public int robBottomUp(int[] nums) {
        if(nums.length==1)
            return nums[0];
       int[] dp = new int[nums.length];
       dp[0]=nums[0];
       dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
