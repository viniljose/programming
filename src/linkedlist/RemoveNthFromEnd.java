package linkedlist;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        removeNthFromEnd.removeNthFromEnd(head,2);
        System.out.println(head.toStringNoSentinel(head));
    }

    //two pass solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;
        while(curr !=null){
            curr=curr.next;
            length++;
        }
        if(length==n)
            return head.next;
        int counter = length-n-1;
        curr = head;
        for (int i = 0; i < counter; i++) {
            curr= curr.next;
        }
        curr.next=curr.next.next;
        return head;
    }
}
