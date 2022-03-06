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
}
