package arrays;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * https://leetcode.com/problems/max-consecutive-ones/
 *
 */
public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {
        FindMaxConsecutiveOnes find = new FindMaxConsecutiveOnes();
        System.out.println(find.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;

        for(int i=0;i<nums.length;i++){
            int currMaxCount = 0;
            while(i<nums.length && nums[i]==1) {
                if (nums[i++]==1)
                    currMaxCount++;
            }
            if (currMaxCount > maxCount)
                maxCount = currMaxCount;
        }
    return maxCount;
    }
}
