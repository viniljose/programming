package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right,
 * and replace the last element with -1.After doing so, return the array.
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 */
public class GreatestElementOnRightSide {
    public static void main(String[] args) {
        GreatestElementOnRightSide greatestElementOnRightSide = new GreatestElementOnRightSide();
        int[] input = new int[]{17,18,5,4,6,1};
        greatestElementOnRightSide.replaceElements(input);
        System.out.println(Arrays.toString(input));
    }

    public int[] replaceElements(int[] arr) {
        if(arr == null)
            return arr;
        int length = arr.length;
        if(length == 1) {
            arr[0]=-1;
            return arr;
        }
        if(length==2)
            arr[0]=arr[1];
        for (int i = 0; i <= length-2; i++) {
            if(i==length-2) {
                arr[i]=arr[i+1];
            }
            int j=i+1;
            arr[i] = arr[j];
            while(j<length-1){
                if(arr[i]< arr[j+1]){
                  arr[i] = arr[j+1];
                }
                j++;
            }
        }
        if(length>1)
            arr[length-1]=-1;
        return arr;
    }

    public int[] replaceElements1(int[] arr) {
        int maxSoFar = arr[arr.length - 1]; //take last element in array as maxVal
        arr[arr.length - 1] = -1;
        //start array traversal from right to left
        for(int i = arr.length - 2; i > -1; i--){
            int currVal = arr[i];
            arr[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, currVal);
            //keep updating maxRight element encountered so far
        }
        return arr;
    }
}

