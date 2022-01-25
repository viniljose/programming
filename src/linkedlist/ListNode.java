package linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString(ListNode head){
        String result ="[";
        if(head == null)
            return "";
        result = result + String.valueOf(head.val);
        ListNode temp = head.next;
        while (temp != null){
            result = result +","+ String.valueOf(temp.val);
            temp = temp.next;
        }
        return result +"]";
    }
}
