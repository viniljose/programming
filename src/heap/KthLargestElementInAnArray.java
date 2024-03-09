package heap;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 */
public class KthLargestElementInAnArray {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if(k > minHeap.size()){
                minHeap.offer(nums[i]);
            } else if (nums[i] > minHeap.poll()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.poll();
    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2)-> n1-n2);
        for(int value : nums){
            minHeap.add(value);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
}
