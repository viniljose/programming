package arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/largest-number/
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 */
public class LargestNumber {

    private class LargeComparator implements Comparator<String> {

        @Override
        public int compare(String a,String b) {
            String order1 = a+b;
            String order2 = b+a;
            return order2.compareTo(order1);
        }
    }
    public String largestNumber(int[] nums) {
        //convert this to a String array
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        //Sort this using custom comparator
        Arrays.sort(strNums,new LargeComparator());
        if(strNums[0].equals("0"))
            return "0";

        String largestNumber = "";
        //Make String array to a String
        for (int i = 0; i < nums.length; i++) {
            largestNumber += strNums[i];
        }
        return largestNumber;
    }
}
