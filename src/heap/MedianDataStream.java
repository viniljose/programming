package heap;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value,
 * and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 *
 * The median of all numbers will either be the largest number in the small list or the smallest number in the large list.
 * If the total number of elements is even, we know that the median will be the average of these two numbers.
 * The most efficient data structure for repeatedly finding the smallest or largest number in a changing list is a heap.
 * We can store the first half of the numbers in a max-heap and the second half in a min-heap.
 */
public class MedianDataStream {
    PriorityQueue<Integer> minheap,maxheap;
    public MedianDataStream() {
        minheap = new PriorityQueue<>((a,b)-> a-b);
        maxheap =  new PriorityQueue<>((a,b)-> b-a);
    }

    public void addNum(int num) {
        if(maxheap.isEmpty() || maxheap.peek()>=num){
            maxheap.add(num);
        } else {
            minheap.add(num);
        }

        if(maxheap.size()>minheap.size()+1){
            minheap.add(maxheap.poll());
        } else if (maxheap.size()<minheap.size()) {
            maxheap.add(minheap.poll());
        }
    }

    public double findMedian() {
        if(maxheap.size()==minheap.size())
            return maxheap.peek()/2.0+minheap.peek()/2.0;
        return maxheap.peek();
    }
}
