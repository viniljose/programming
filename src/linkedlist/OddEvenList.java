package linkedlist;

public class OddEvenList {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);
        OddEvenList oddEvenList = new OddEvenList();
        System.out.println(head.toStringNoSentinel( oddEvenList.oddEvenList(head)));
    }
    public ListNode oddEvenList(ListNode head) {
        if (head==null)
            return null;
        ListNode odd=head,even = head.next,evenHead =even;
        while (even!=null && even.next!=null){
            odd.next =even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
}
