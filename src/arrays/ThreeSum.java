package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, 
 * and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * Input: nums = [-1,0,1,2,-1,-4] [[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {
    
    //Time complexity : O(n*2)
    //Space complexity : O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <=0; i++) {
            if(i==0 || nums[i]!=nums[i-1]){
                twoSumII(res, i, nums);
            }
        }
        return res;
    }
    private void twoSumII(List<List<Integer>> res,int i,int[] nums){
        int lo=i+1,hi=nums.length-1;
        while(lo < hi){
            int sum = nums[i]+nums[lo]+nums[hi];
            if(sum <0) lo++;
            else if (sum >0 ) hi--;
            else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while(lo < hi && nums[lo]==nums[lo-1]){
                    lo++;
                }
            }
        }
    }
}
