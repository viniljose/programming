package linkedlist;

public class ListReverse {
    public static void main(String[] args) {
        ListReverse reverse = new ListReverse();
        ListNode node3 = new ListNode(3,null);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);
        System.out.println(head.toString(head));
        System.out.println(head.toString(reverse.reverseList(head)));
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
