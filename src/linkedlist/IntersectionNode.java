package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionNode {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(4);
        ListNode node4 = new ListNode(2,node5);
        ListNode node3 = new ListNode(1,node4);
        ListNode node2 = new ListNode(9,node3);
        ListNode head = new ListNode(1,node2);

       // ListNode node7 = new ListNode(4);
        //ListNode node6 = new ListNode(2,node7);
        ListNode head2 = new ListNode(3,node4);

        IntersectionNode intersectionNode = new IntersectionNode();
        System.out.println(intersectionNode.getIntersectionNode(head,head2).val);
         System.out.println(intersectionNode.getIntersectionNodeFinal(head,head2).val);
    }
    //o(m+n) o(n)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set nodesInB= new HashSet();
        while (headB!=null){
            nodesInB.add(headB);
            headB=headB.next;
        }
        while (headA!=null){
            if(nodesInB.contains(headA))
                return headA;
            headA=headA.next;
        }
        return null;
    }
    //o(m+n)o(1)
    public ListNode getIntersectionNodeFinal(ListNode headA, ListNode headB) {
        ListNode pA=headA,pB=headB;
        while (pA!=pB){
            pA =(pA==null?headB:pA.next);
            pB =(pB==null?headA:pB.next);
        }
        return pA;
    }
}
