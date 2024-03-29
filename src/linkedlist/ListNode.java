package linkedlist;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString(ListNode head){
        String result ="[";
        if(head == null)
            return "";
        //commented for sentinel
        //result = result + String.valueOf(head.val);
        ListNode temp = head.next;
        while (temp != null){
            result = result +","+ String.valueOf(temp.val);
            temp = temp.next;
        }
        return result +"]";
    }

    public int length(ListNode head){
        int length =0;
        ListNode curr = head;
        while (curr!= null){
            curr=curr.next;
            length++;
        }
        return length;
    }

    public String toStringNoSentinel(ListNode head){
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
