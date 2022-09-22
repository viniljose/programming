package arrays;

/**
 * https://leetcode.com/problems/remove-element/
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2]
 */
public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = new int[]{3,2,2,3};
        System.out.println(removeElement.removeElement1(nums,3));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+",");
        }

        int[] nums1 = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement.removeElement1(nums1,2));
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]+",");
        }
    }
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (length ==0 )
            return 0;
        int removed = 0;
        for (int i = 0; i < length; i++) {
            if(nums[i]==val){
                int j=i;
                while(j<length-1){
                    nums[j]=nums[j+1];
                    j++;
                }
                removed++;
                nums[length-removed] = val +100;
            }
        }
        return removed;
    }

    public int removeElement1(int[] nums, int val) {
        int len = nums.length;
        if (len ==0 )
            return 0;
        int j=0;
        for (int i=0;i<len;i++){
            if(nums[i]!=val){
                j++;
                nums[j-1]=nums[i];
            }
        }
        return j;
    }
}
