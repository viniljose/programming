package tree.bst;

import linkedlist.ListNode;
import tree.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 */
public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        ListNode mid = findMiddleElement(head);
        TreeNode node = new TreeNode(mid.val);
        if(head==mid)
            return node;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    private ListNode findMiddleElement(ListNode head){
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            prev = slow;
            slow =slow.next;
            fast = fast.next.next;
        }
        if(prev != null){
            prev.next = null;
        }
        return slow;
    }
}
