package linkedlist;

public class LLAddTwoNumbers {

    public static void main(String[] args) {
        LLAddTwoNumbers addTwoNumbers = new LLAddTwoNumbers();
        ListNode node13 = new ListNode(3,null);
        ListNode node12 = new ListNode(4,node13);
        ListNode head1 = new ListNode(2,node12);

        ListNode node23 = new ListNode(4,null);
        ListNode node22 = new ListNode(6,node23);
        ListNode head2 = new ListNode(5,node22);

        System.out.println(head1.toString(addTwoNumbers.addTwoNumbers(head1,head2)));

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p=l1,q=l2,curr =result;
        int carry = 0;
        while (p!=null || q!= null){
            int x = (p!=null)?p.val:0;
            int y = (q!=null)?q.val:0;
            int sum = carry + x + y;
            carry = sum/10;
            curr.next= new ListNode(sum%10);
            curr=curr.next;
            if(p!=null) p= p.next;
            if(q!=null) q= q.next;
        }
        if(carry>0)curr.next=new ListNode(carry);
        return result.next;
    }
}
