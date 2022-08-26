package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==k)
            return nums;
        //Create a MAP containing frequency of each elements
        Map<Integer,Integer> frequency = new HashMap<>();
        for(int n:nums)
            frequency.put(n,frequency.getOrDefault(n,0)+1);

        //Create a heap with less frequent elements at top
        Queue<Integer> heap = new PriorityQueue<>(
                (n1,n2)->frequency.get(n1)-frequency.get(n2)
        );

        //add frequency key elements maximum of k
        for(int i :frequency.keySet()){
            heap.add(i);
            if(heap.size()>k)
                heap.poll();
        }

        //Convert heap to an output array
        int[] most = new int[k];
        for (int i = k-1; i >=0; i--) {
            most[i]=heap.poll();
        }
        return most;
    }
}
