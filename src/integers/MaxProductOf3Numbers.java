package integers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 * Input: nums = [1,2,3,4]
 * Output: 24
 */
public class MaxProductOf3Numbers {
    //TC o(nlogn)
    //SC o(nlogn)
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[nums.length-1],nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
    }
}
