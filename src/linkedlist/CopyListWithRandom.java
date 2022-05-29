package linkedlist;

import java.util.HashMap;
import java.util.Map;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

/**
 * A linked list of length n is given such that each node contains an additional random pointer, 
 * which could point to any node in the list, or null.
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node
 *  has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes 
 * should point to new nodes in the copied list such that the pointers in the original list and copied list represent 
 * the same list state. None of the pointers in the new list should point to nodes in the original list.
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
public class CopyListWithRandom{
    Map<Node,Node> map = new HashMap<Node,Node>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
          }

        if(map.containsKey(head)){
            return map.get(head);
        }
        Node newNode = new Node(head.val,null,null);
        map.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }
}