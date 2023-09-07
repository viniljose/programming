package arrays;

/**
 * https://leetcode.com/problems/longest-mountain-in-array/description/
 * You may recall that an array arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.
 * Input: arr = [2,1,4,7,3,2,5]
 * Output: 5
 */
public class LongestMountainInAnArray {
    public int longestMountain(int[] arr) {
        int len = arr.length;
        int ans=0,base=0;
        while(base<len){
            int end = base;
            if(end+1<len && arr[end]<arr[end+1]) {
                while (end + 1 < len && arr[end] < arr[end + 1]) end++;

                if (end + 1 < len && arr[end] > arr[end + 1]) {
                    while (end + 1 < len && arr[end] > arr[end + 1]) end++;
                    ans = Math.max(ans, end - base + 1);
                }
            }
            base=Math.max(base+1,end);
        }
        return ans;
    }
}
