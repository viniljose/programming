package arrays;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 */
public class MaximunSubArray {
    //o(n*2)
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum+=nums[j];
                maxSum = Math.max(maxSum,currentSum);
            }
        }
        return maxSum;
    }

    //o(n)
    public int maxSubArray1(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i],currSum+nums[i]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}
