package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LLCycle {
    public static void main(String[] args) {
        LLCycle cycle = new LLCycle();
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(0,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode head = new ListNode(3,node2);
        node4.next=node2;
        System.out.println(cycle.hasCycle(head));
        System.out.println(cycle.detectCycle(head).val);

        ListNode node13 = new ListNode(3,null);
        ListNode node12 = new ListNode(2,node13);
        ListNode head1 = new ListNode(1,node12);
        System.out.println(cycle.hasCycle(head1));
        System.out.println(cycle.detectCycle(head1));
    }
    public boolean hasCycle(ListNode head) {
        Set content = new HashSet();
        while (head!=null){
            if(content.contains(head))
                return true;
            content.add(head);
            head = head.next;
        }
        return false;
    }
    
    public ListNode detectCycle(ListNode head) {
        Set content = new HashSet();
        while (head!=null){
            if(content.contains(head)){
                return head;
            }
            content.add(head);
            head=head.next;
        }
        return null;
    }
}
