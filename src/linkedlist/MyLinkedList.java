package linkedlist;

public class MyLinkedList {
    private ListNode head;
    int size =0;
    public MyLinkedList() {
        head = new ListNode(0);
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.addAtHead(1);
        ll.addAtTail(3);
        ll.print();
        ll.addAtIndex(1,2);
        System.out.println(ll.get(1));
        ll.deleteAtIndex(1);
        System.out.println(ll.get(1));
    }

    public void print(){
        System.out.println(head.toString(head));
    }

    public int get(int index) {
        if(index < 0 || index>size) return -1;
        ListNode curr = head;
        for (int i = 0; i < index+1; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index>size) return;
        if(index<0) index=0;
        size++;
        ListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr=curr.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next=curr.next;
        curr.next=toAdd;
    }

    public void deleteAtIndex(int index) {
        if(index<0 || index>=size)
            return;
        size--;
        ListNode curr = head;
        for (int i = 0; i < index; i++) {
        curr=curr.next;
        }
        curr.next=curr.next.next;
    }
}
