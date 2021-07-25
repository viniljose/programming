package arrays;

import java.util.Arrays;

/**
 * Given an Array of integers, return an Array where every element at an even-indexed position is squared.
 */
public class SqureEven {
    public static void main(String[] args) {
        SqureEven squreEven = new SqureEven();
        int[] evened = squreEven.squreEven(new int[]{9, -2, -9, 11, 56, -12, -3},7);
        System.out.println(Arrays.toString(evened));

    }

    public int[] squreEven(int[] array,int length){
        if(array == null)
            return array;
        for(int i=0;i<length;i++){
            if(i%2==0)
                array[i]=array[i]*array[i];
        }
        return array;
    }
}
