package arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3237/
 * Given an array nums of integers, return how many of them contain an even number of digits.
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 */
public class EvenNumberOfDigits {
    public static void main(String[] args) {
        EvenNumberOfDigits even = new EvenNumberOfDigits();
        System.out.println(even.findNumbers(new int[]{12,345,2,6,7896}));

    }

    public int findNumbers(int[] nums) {
        int totalEven = 0;
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if(isEvenDigits(number))
                totalEven++;
        }
    return totalEven;
    }

    private boolean isEvenDigits(int number){
        int totalDigits = 0;
        while (number / 10 !=0) {
            totalDigits++;
            number = number / 10;
        }
        return (totalDigits+1) % 2==0;
    }
}
