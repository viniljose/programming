package heap;

import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2)-> n1-n2);
        for(int value : nums){
            minHeap.add(value);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }

    public static void main(String[] args) {
        FindKthLargest largest = new FindKthLargest();
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(largest.findKthLargest(nums,2));
    }
}

