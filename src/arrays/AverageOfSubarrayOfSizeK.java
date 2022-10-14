package arrays;

/**
 * Given an array, find the average of each subarray of ‘K’ contiguous elements in it.
 * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 * Output: [2.2, 2.8, 2.4, 3.6, 2.8]
 * This uses sliding window pattern
 */
public class AverageOfSubarrayOfSizeK {

    public double[] findAverages(int k, int[] arr) {
        double[] result = new double[arr.length-k+1];
        double windowSum = 0;
        int windowStart = 0;
        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];
            if(i>=k-1){
                result[windowStart] = windowSum/k;
                windowSum-=arr[windowStart];
                windowStart++;
            }
        }
        return result;
    }
}
