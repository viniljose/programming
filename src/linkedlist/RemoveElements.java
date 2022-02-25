package linkedlist;

public class RemoveElements {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(6);
        ListNode node4 = new ListNode(3,node5);
        ListNode node3 = new ListNode(6,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);
        RemoveElements remove = new RemoveElements();
        System.out.println(head.toStringNoSentinel( remove.removeElements(head,6)));
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head==null)
            return null;
        ListNode sentinel = new ListNode(0);
        sentinel.next=head;

        ListNode curr =head;
        ListNode prev = sentinel;
        while (curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            } else
                prev=curr;
            curr=curr.next;
        }
        return sentinel.next;
    }
}
