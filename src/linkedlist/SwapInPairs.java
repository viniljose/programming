package linkedlist;


/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * Given a linked list, swap every two adjacent nodes and return its head.
 */
public class SwapInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode prev = preHead;
        while (head != null && head.next!=null){
            ListNode first = head;
            ListNode second = head.next;
            prev.next = second;
            first.next=second.next;
            second.next=first;
            prev=first;
            head=first.next;
        }
        return preHead.next;
    }
}
