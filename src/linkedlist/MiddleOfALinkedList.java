package linkedlist;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * Given the head of a singly linked list, return the middle node of the linked list.
 */
public class MiddleOfALinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
