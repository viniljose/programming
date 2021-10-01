package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3157/
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,12};
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = new int[] {1,0,1};
        moveZeros.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    public void moveZeroes(int[] nums) {
     // Check for edge cases.
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return ;
        }

        int writePointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[writePointer++]=nums[i];
            }
        }
        for (int i = writePointer; i < nums.length; i++) {
            nums[i]=0;
        }

    }
}
