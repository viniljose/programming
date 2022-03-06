package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(1);
        ListNode node4 = new ListNode(2,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(head));
        System.out.println(isPalindrome.isPalindromeFinal(head));
    }

    //o(n),o(n)
    public boolean isPalindrome(ListNode head) {
        List<Integer> contents = new ArrayList<Integer>();
        ListNode curr = head;
        while (curr != null){
            contents.add(curr.val);
            curr=curr.next;
        }
        List<Integer> reverse = new ArrayList<Integer>();
        int len = contents.size();
        for (int i = len -1; i >=0 ; i--) {
            reverse.add(contents.get(i));
        }
        for (int i = 0; i < len-1; i++) {
            if(contents.get(i)!=reverse.get(i)){
                return false;
            }
        }
        return true;
    }

    //o(n)o(1)
    public boolean isPalindromeFinal(ListNode head) {
        if(head == null) return true;
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null){
            if(p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }
    private ListNode endOfFirstHalf(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
