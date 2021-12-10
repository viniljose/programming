package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/
 *
 */
public class PlusOneArray {

    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1;i >= 0;i--){

            if(digits[i]<9) {
                digits[i]++;
                return digits;
            }
            else             // i.e digits[0]==0;
                digits[i]=0;

        }

        int[] plus = new int[digits.length+1];
        plus[0] = 1;

        return plus;
    }

    public static void main(String[] args) {
        PlusOneArray plusOneArray = new PlusOneArray();
        System.out.println(Arrays.toString(plusOneArray.plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(plusOneArray.plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOneArray.plusOne(new int[]{1,9,9})));
        System.out.println(Arrays.toString(plusOneArray.plusOne(new int[]{0})));
    }
}
