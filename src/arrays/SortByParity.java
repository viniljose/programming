package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3260/
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 */
public class SortByParity {
    public static void main(String[] args) {
        int[] nums = new int[] {3,1,2,4};
        SortByParity sortByParity = new SortByParity();
        sortByParity.sortArrayByParity(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int[] sortArrayByParity(int[] nums) {
        //check the number is even or odd
        //if odd move to next element
        //if even swap it with first element, then move to next
        //Keep a tracker of even element position

        // Check for edge cases.
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int tracker = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2 == 0){
                int temp = nums[i];
                nums[i]=nums[tracker];
                nums[tracker] = temp;
                tracker++;
            }
        }

        return nums;
    }
}
