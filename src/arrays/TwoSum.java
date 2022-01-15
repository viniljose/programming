package arrays;

import java.util.HashMap;

/**
 * https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/173/
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 */
public class TwoSum {

    public static void main(String[] args) {

        TwoSum sum = new TwoSum();
        int[] input = new int[]{2,7,11,15};
        int[] sol = sum.twoSumSorted(input,9);
        System.out.println("----->"+sol[0]+" , "+sol[1]);

        int[] sol1 = sum.twoSum(input,9);
        System.out.println("----->"+sol1[0]+" , "+sol1[1]);

        input = new int[]{2,7,9,14,17};
        sol = sum.twoSumSorted(input,11);
        System.out.println("----->"+sol[0]+" , "+sol[1]);

        int[] sol2 = sum.twoSum(input,11);
        System.out.println("----->"+sol2[0]+" , "+sol2[1]);
    }


    /**
     * Array is sorted
     * {2,7,11,15}
     * target = 9
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSumSorted(int[] numbers, int target) {
        int j = numbers.length-1;
        int[] sol = new int[2];
         for(int i=0;i<j;){
             if( numbers[i]+numbers[j]== target) {
                 sol[0]=i;
                 sol[1]=j;
                 return sol;
             } else if (numbers[i]+numbers[j] > target) {
                 j--;
             } else {
                 i++;
             }
         }
         return sol;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                result[0] = index ;
                result[1] = i;
                break;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return result;
    }

    //DS for Two Sum

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int value){
        if(map.containsKey(value)){
            map.put(value,map.get(value)+1);
        } else {
            map.put(value,1);
        }
    }

    public boolean find (int target) {
     for(Integer i :map.keySet()){
        int value = target - i;
        if(map.containsKey(value)){
            if(i==value && map.get(i)<2)
                continue;
            return true;
        }
     }
        return false;
    }

}
