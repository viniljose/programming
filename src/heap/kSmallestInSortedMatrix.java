package heap;

import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class kSmallestInSortedMatrix {
    class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public  int findKthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1,n2)->matrix[n1.row][n1.col]-matrix[n2.row][n2.col]);
        //add first element of each row to heap
        for (int i = 0; i < matrix.length && i<k; i++) {
            minHeap.add(new Node(i,0));
        }
        int counter = 0;
        int smallest = 0;
        while (!minHeap.isEmpty()){
            Node node = minHeap.poll();
            smallest = matrix[node.row][node.col];
            if(++counter==k)
               break;
            node.col++;
            if(matrix[0].length>node.col)
                minHeap.add(node);
        }
        return smallest;
    }

}
