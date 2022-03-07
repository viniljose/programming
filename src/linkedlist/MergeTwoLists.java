package linkedlist;

public class MergeTwoLists {
    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode node13 = new ListNode(5,null);
        ListNode node12 = new ListNode(4,node13);
        ListNode head1 = new ListNode(1,node12);

        ListNode node24 = new ListNode(6,null);
        ListNode node23 = new ListNode(3,node24);
        ListNode node22 = new ListNode(2,node23);
        ListNode head2 = new ListNode(1,node22);
        ListNode merged = mergeTwoLists.mergeTwoLists(head1,head2);
        System.out.println(merged.toString(merged));
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (list1 != null && list2 !=null){
            if(list1.val<= list2.val){
                prev.next = list1;
                list1 =list1.next;
            } else {
                prev.next = list2;
                list2=list2.next;
            }
            prev =prev.next;
        }
        prev.next=list1==null? list2:list1;
        return preHead.next;
    }
}
