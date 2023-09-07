package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2]
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {

        RemoveDuplicatesFromSortedArray rm = new RemoveDuplicatesFromSortedArray();
        //System.out.println(rm.removeDuplicates(new int[] {1,1,2}));
        System.out.println(rm.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
        System.out.println(Arrays.toString(rm.copyWithRemovedDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4})));

    }

    //better approach
    public int removeDuplicates(int[] nums) {
       int len = nums.length;
        if (len ==0 )
            return 0;
        if(len == 1)
            return 1;
        int length =1;
        for (int i=0;i<len-1;i++){
            if (nums[i]!=nums[i+1]){
                length++;
                nums[length-1]=nums[i+1];
            }
        }
        return length;

    }

    /**
     * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3256/
     * Given a sorted array, remove the duplicates such that each element appears only once.
     * Input: array = [1, 1, 2]
     * Output: [1, 2]
     * Input: array = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
     * Output: [0, 1, 2, 3, 4]
     * @param nums
     * @return
     */
    public int[] copyWithRemovedDuplicates(int[] nums) {
        // Check for edge cases.
        if (nums == null || nums.length == 0) {
            return nums;
        }

        // Count how many unique elements are in the Array.
        int uniqueNumbers = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i==0 || nums[i]!=nums[i-1])
                uniqueNumbers++;
        }

        // Create a result Array.
        int[] result = new int[uniqueNumbers];
        int position = 0;

        // Write the unique elements into the result Array.
        for (int i = 0; i < nums.length; i++) {
            if(i==0 || nums[i]!=nums[i-1]) {
                result[position] = nums[i];
                position++;
            }
        }
    return result;
    }
}
