package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/
 * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 * Input: arr = [10,2,5,3]
 * Output: true
 */
public class DoubleExists {

    public static void main(String[] args) {
        DoubleExists doubleExists = new DoubleExists();
       // System.out.println(doubleExists.checkIfExist(new int[]{10,2,5,3}));
        System.out.println(doubleExists.checkIfExist(new int[]{3,1,7,11}));
    }

    public boolean checkIfExist(int[] arr) {
        Set<Integer> numbers = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if(numbers.contains(arr[i]*2) || (numbers.contains(arr[i]/2) && arr[i]%2==0)){
                return true;
            } else {
                numbers.add(arr[i]);
            }
        }
    return false;
    }
}
