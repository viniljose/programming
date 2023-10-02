package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/happy-number/
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int slowPointer = n;
        int fastPointer = sumOfSquaredDigits(n);

        while (fastPointer != 1 && slowPointer != fastPointer) {
            slowPointer = sumOfSquaredDigits(slowPointer);
            fastPointer =  sumOfSquaredDigits(sumOfSquaredDigits(fastPointer));
        }
        return fastPointer == 1;
    }
     private int sumOfSquaredDigits(int num){
        int sum = 0;
        while(num!=0){
            int lastDigit = num%10;
            sum=sum+lastDigit*lastDigit;
            num=num/10;
        }
        return sum;
     }
}
