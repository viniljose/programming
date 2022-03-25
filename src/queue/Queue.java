package queue;

import linkedlist.ListNode;

public class Queue {
    private ListNode head,tail;
    private int capacity;
    private int size;

    public Queue(int k) {
        capacity=k;
        size=0;
    }

    public boolean enQueue(int value) {
        if (capacity==size)
            return false;
        ListNode newNode = new ListNode(value);
        if(size==0)
            head=tail= newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size==0)
            return false;
        head=head.next;
        size--;
        return true;
    }

    public int Front() {
        if(size==0)
            return -1;
        return head.val;
    }

    public int Rear() {
        if(size==0)
            return -1;
        return tail.val;
    }

    public boolean isEmpty() {
        if(size==0)
            return true;
        return false;
    }

    public boolean isFull() {
        if(size==capacity)
            return true;
        return false;
    }
}
