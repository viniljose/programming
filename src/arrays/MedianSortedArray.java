package arrays;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianSortedArray {

    public static void main(String[] args) {
        MedianSortedArray median = new MedianSortedArray();
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(median.findMedianSortedArrays(nums1,nums2));

        int[] nums3 = new int[]{1,3};
        int[] nums4 = new int[]{2};
        System.out.println(median.findMedianSortedArrays(nums3,nums4));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = merge(nums1,nums1.length,nums2,nums2.length);
        int len = result.length;
        System.out.println(len);
        if(len%2!=0)
            return result[len/2];
        else{
            double a = result[len/2];
            double b = result[(len/2)-1];
            return (a+b)/2;
        }
    }

    private int[] merge(int[] nums1, int m, int[] nums2, int n){
        int[] result = new int[m+n];
        for (int i = 0; i < m; i++) {
            result[i]=nums1[i];
        }
        int p1 = m - 1;
        int p2 = n - 1;
        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                result[p] = nums1[p1--];
            } else {
                result[p] = nums2[p2--];
            }
        }
        return result;
    }
}
