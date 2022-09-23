package arrays;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {
    public static void main(String[] args) {

    }
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return -1;
        int i =0,j=len-1;
        while (i<=j){
            int mid = (i+j)/2;
            if(nums[mid]==target) return mid;
            else if (target > nums[mid]){
                i=mid+1;
            } else {
                j=mid-1;
            }
        }
    return i;
    }
}
