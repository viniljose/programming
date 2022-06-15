package arrays;
public class FindFirstAndLast {
    /**
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
     * If target is not found in the array, return [-1, -1].
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     */
    public int[] searchRange(int[] nums, int target) {
        int first = find(nums,target,true);
        if(first==-1)
            return new int[]{-1,-1};
        int last = find(nums,target,false);
        return new int[]{first,last};
    }
    private int find(int[] nums,int target,boolean isFirst){
        int n = nums.length;
        int begin = 0, end = n - 1;
        while(begin<=end){
            int mid = (begin+end)/2;
            if(nums[mid]==target){
                if(isFirst){
                    if(mid==begin || nums[mid-1]!=target)
                        return mid;
                    end = mid-1;
                } else {
                    if(mid==end || nums[mid+1]!=target)
                        return mid;
                    begin = mid+1;
                }

            } else if(nums[mid]>target){
                end = mid-1;
            } else {
                begin = mid+1;
            }
        }
        return -1;
    }
}
