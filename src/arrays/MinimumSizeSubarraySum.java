package arrays;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray
 * [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray,
 * return 0 instead.
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int sum =0,left=0,ans=Integer.MAX_VALUE,n=nums.length;
        for (int i = 0; i < n; i++) {
            sum+=nums[i];
            while (sum>=target){
                ans = Math.min(ans,i+1-left);
                sum-=nums[left++];
            }
        }
        return ans!=Integer.MAX_VALUE?ans:0;
    }
}
