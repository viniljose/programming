package arrays;
/*
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/
 */
public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
        int[] data1 = new int[]{3,6,1,0};
        LargestNumberAtLeastTwiceOfOthers largest = new LargestNumberAtLeastTwiceOfOthers();
        System.out.println(largest.dominantIndex(data1));
    }

    public int dominantIndex(int[] nums) {
        if(nums.length==1) return 0;
        int largest = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if(largest<nums[i]) {
                largest = nums[i];
                index = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if((i!=index) && (largest<2*nums[i]))
                return -1;
        }
        return index;
    }
}
