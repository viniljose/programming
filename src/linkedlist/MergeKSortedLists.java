package linkedlist;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1,n2)->n1.val-n2.val);
        for (ListNode node :lists)
            if(node!=null)
            minHeap.add(node);
        ListNode head = null,resultTail = null;
        while (!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            if(head==null)
                head=resultTail=node;
            else {
                resultTail.next = node;
                resultTail = resultTail.next;
            }
            if(node.next!=null)
                minHeap.add(node.next);
        }
        return head;
    }
}
