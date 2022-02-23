package linkedlist;

public class DoublyLinkedList {
    int size =0;
    DoublyListNode head,tail;
    DoublyLinkedList (){
        head=new DoublyListNode(0);
        tail=new DoublyListNode(0);
        head.next=tail;
        tail.pre=head;
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0 || index>=size)
            return -1;
        DoublyListNode curr = head;
        if(index+1<size-index){
            for (int i = 0; i < index+1; i++) {
                curr=curr.next;
            }
        } else {
            curr=tail;
            for (int i = 0; i < size-index; i++) {
                curr=curr.pre;
            }
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        DoublyListNode pred=head,succ=head.next;
        size++;
        DoublyListNode toAdd= new DoublyListNode(val);
        toAdd.pre=pred;
        toAdd.next=succ;
        pred.next=toAdd;
        succ.pre=toAdd;
    }

    public void addAtTail(int val) {
        DoublyListNode pred=tail.pre,succ=tail;
        size++;
        DoublyListNode toAdd= new DoublyListNode(val);
        toAdd.pre=pred;
        toAdd.next=succ;
        pred.next=toAdd;
        succ.pre=toAdd;
    }

    public void addAtIndex(int index, int val) {
        if(index>size) return;
        if(index<0) index=0;

        // find predecessor and successor of the node to be added
        DoublyListNode pred,succ;
        if(index<size-index){
            pred=head;
            for (int i = 0; i < index; i++) {
                pred=pred.next;
            }
            succ=pred.next;
        } else {
            succ=tail;
            for (int i = 0; i < size-index; i++) {
                succ=succ.pre;
            }
            pred=succ.pre;
        }
        size++;
        DoublyListNode toAdd= new DoublyListNode(val);
        toAdd.next=succ;
        toAdd.pre=pred;
        pred.next=toAdd;
        succ.pre=toAdd;
    }

    public void deleteAtIndex(int index) {
        if(index<0 || index>=size) return;
        // find predecessor and successor of the node to be added
        DoublyListNode pred,succ;
        if(index<size-index){
            pred=head;
            for (int i = 0; i < index; i++) {
                pred=pred.next;
            }
            succ=pred.next.next;
        } else {
            succ=tail;
            for (int i = 0; i < size-index-1; i++) {
                succ=succ.pre;
            }
            pred=succ.pre.pre;
        }
        --size;
        pred.next=succ;
        succ.pre=pred;
    }

    public void print(){
        System.out.println(head.toString(head));
    }

    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.addAtHead(1);
        ll.addAtTail(3);
        ll.print();
        ll.addAtIndex(1,2);
        ll.print();
        ll.deleteAtIndex(1);
        ll.print();

        //Test Case 2
        System.out.println("--------Case 2-----------");
        DoublyLinkedList case2 = new DoublyLinkedList();
        case2.addAtHead(4);
        case2.print();
        case2.addAtHead(1);
        case2.addAtHead(5);
        case2.print();
        case2.deleteAtIndex(2);
        case2.addAtHead(7);
        case2.print();
        case2.addAtHead(1);
        case2.deleteAtIndex(4);
        case2.print();
    }

}
