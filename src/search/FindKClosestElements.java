package search;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements/description/
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 *
 * An integer a is closer to x than an integer b if:
 *
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int length = arr.length;
        List<Integer> result = new ArrayList<>();
        //Case 1 if length of array is same as k
        if (length == k) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        //case 2 if the number is less than the lowest element in the array
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        //case 3 if the number is greater than the largest element in the array
        if (x >= arr[length - 1]) {
            for (int i = length - k; i < length; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        int firstClosest = new BinarySearch().search(arr, x);
        //TODO case where firstClosest ==-1 not handled.
        int windowLeft = firstClosest - 1;
        int windowRight = firstClosest + 1;

        while ((windowRight - windowLeft - 1) < k) {
            if (windowLeft == -1) {
                windowRight++;
                continue;
            }

            if (windowRight == length || Math.abs(arr[windowLeft] - x) <= Math.abs(arr[windowRight] - x)) {
                windowLeft--;
            } else {
                windowRight++;
            }
        }
        for (int i = windowLeft + 1; i < windowRight; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
