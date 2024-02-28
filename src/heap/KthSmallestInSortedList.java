package heap;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Kth Smallest Number in M Sorted Lists
 * Given an m number of sorted lists in ascending order and an integer, k, find the kth smallest number among all the given lists.
 *
 * Although there can be repeating values in the lists, each element is considered unique and, therefore, contributes to calculating the kth smallest element.
 *
 * If k is greater than the total number of elements in the input lists, return the greatest element from all the lists and if there are no elements in the input lists, return 0.
 */
public class KthSmallestInSortedList {
    public int kSmallestNumber(List<List<Integer>> lists, int k) {
        int listSize = lists.size();
        //Populate Minheap with first element from each List
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for (int i = 0; i < listSize; i++) {
            if(lists.get(i).size()==0)
                continue;
            else {
                minheap.offer(new int[]{lists.get(i).get(0),i,0});
            }
        }
        int kthSmallest = 0, numbersChecked = 0;
        while (!minheap.isEmpty()){
            int[] smallest = minheap.poll();
            kthSmallest = smallest[0];
            int currentListIndex = smallest[1];
            int curentElementIndex = smallest[2];
            numbersChecked++;
            if(numbersChecked==k){
                break;
            }
            if(curentElementIndex+1 < lists.get(currentListIndex).size()){
                minheap.offer(new int[]{lists.get(currentListIndex).get(curentElementIndex+1),currentListIndex,curentElementIndex+1});
            }
        }
        return kthSmallest;
    }
}
