package arrays;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        mergeSortedArray.merge(nums1,3,new int[]{2,5,6},3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]+",");
        }

        int[] nums2 = new int[]{1};
        mergeSortedArray.merge(nums2,1,new int[]{},0);
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i]+",");
        }

        int[] nums3 = new int[]{0};
        mergeSortedArray.merge(nums3,0,new int[]{1},1);
        for (int i = 0; i < nums3.length; i++) {
            System.out.print(nums3[i]+",");
        }

        int[] nums4 = new int[]{4,5,6,0,0,0};
        mergeSortedArray.merge(nums4,3,new int[]{1,2,3},3);
        for (int i = 0; i < nums4.length; i++) {
            System.out.print(nums4[i]+",");
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            int j=0;
            while(j<n){
                nums1[j]=nums2[j];
                j++;
            }
            return;
        }
        if(n==0){
           return;
        }
       while(m>0 && n>0){
           if(nums1[m-1]>nums2[n-1]){
               nums1[m+n-1]=nums1[m-1];
               m--;
           } else {
               nums1[m+n-1]=nums2[n-1];
               n--;
           }
       }
       while(n>0){
           nums1[m+n-1]=nums2[n-1];
           n--;
       }
    }
}
