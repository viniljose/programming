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

        ListNode node51 = new ListNode(5);
        ListNode node41 = new ListNode(4,node51);
        ListNode node31 = new ListNode(3,node41);
        ListNode node21 = new ListNode(2,node31);
        ListNode head1 = new ListNode(1,node21);
        RemoveNthFromEnd removeNthFromEndOnePass = new RemoveNthFromEnd();
        removeNthFromEnd.removeNthFromEndOnePass(head1,2);
        System.out.println(head.toStringNoSentinel(head1));
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

    public ListNode removeNthFromEndOnePass(ListNode head, int n) {
        ListNode curr = head;
        for (int i = 0; i < n; i++) {
            curr=curr.next;
        }
        if(curr==null)
            return head.next;
        ListNode beforeRemoval =head;
        while (curr.next!=null){
            curr=curr.next;
            beforeRemoval=beforeRemoval.next;
        }
        beforeRemoval.next=beforeRemoval.next.next;
        return head;
    }
}
