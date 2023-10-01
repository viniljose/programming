package arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class SortColors {
    public void sortColors(int[] nums) {

        int red =0,white=0,blue=nums.length-1;

        //[2,0,2,1,1,0]
        //[0,0,2,1,1,2]
        //[0,0,1,1,2,2]
        while(white<=blue){
            if(nums[white]==0){
                if(nums[red]!=0){
                    int tmp = nums[red];
                    nums[red] = nums[white];
                    nums[white] = tmp;
                }
                white++;
                red++;
            } else if (nums[white]==1) {
                white++;
            } else {
                int tmp = nums[blue];
                nums[blue] = nums[white];
                nums[white] = tmp;
                red--;
            }
        }
    }
}
