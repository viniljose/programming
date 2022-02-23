package linkedlist;

public class DoublyListNode {
    int val;
    DoublyListNode next;
    DoublyListNode pre;
    DoublyListNode (){}
    DoublyListNode(int val){
        this.val=val;
    }

    public String toString(DoublyListNode head){
        String result ="[";
        if(head == null)
            return "";
        //commented for sentinel
        //result = result + String.valueOf(head.val);
        DoublyListNode temp = head.next;
        while (temp.next != null){
            result = result +","+ String.valueOf(temp.val);
            temp = temp.next;
        }
        return result +"]";
    }
}
