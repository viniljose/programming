package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3240/
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 */
public class SortedSquares {
    public static void main(String[] args) {
        SortedSquares sortedSquares = new SortedSquares();
        int[] result = sortedSquares.sortedSquares(new int[]{-4,-1,0,3,10});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+",");
        }

    }

    public int[] sortedSquares(int[] nums) {
        int[] sortedSquares = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i] * nums[i];
            sortedSquares[i]=number;
        }
        Arrays.sort(sortedSquares);
    return sortedSquares;
    }

    public int[] sortedSquares1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }
}


