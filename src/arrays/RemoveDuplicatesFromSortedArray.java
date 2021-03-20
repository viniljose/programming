package arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3248/
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2]
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {

        RemoveDuplicatesFromSortedArray rm = new RemoveDuplicatesFromSortedArray();
        //System.out.println(rm.removeDuplicates(new int[] {1,1,2}));
        System.out.println(rm.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
    }

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
}
