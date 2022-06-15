package heap;
/**
 * A common misconception is that a Heap is the same as a Priority Queue, which is not true.
 * A priority queue is an abstract data type, while a Heap is a data structure.
 * Therefore, a Heap is not a Priority Queue, but a way to implement a Priority Queue.
 *  Implementing the priority queue with Heap will allow both insertion and deletion to have
 *  a time complexity of O(\log N)O(logN).
 *   A heap is a binary tree that meets the following criteria:
 *   Is a complete binary tree;
 *   The value of each node must be no greater than (or no less than) the value of its child nodes.
 *   Max Heap: Each node in the Heap has a value no less than its child nodes. Therefore, the top element (root node) has the largest value in the Heap.
 *   Min Heap: Each node in the Heap has a value no larger than its child nodes. Therefore, the top element (root node) has the smallest value in the Heap.
 */
public class MinHeap {
    private int capacity;
    private int size;
    private int[] minHeap;
    public MinHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        minHeap = new int[capacity+1];
        minHeap[0]=0;
    }
    public void add(int element){
        if(size==capacity){
            System.out.println("Heap is full");
            return;
        }
        size++;
        minHeap[size] = element;
        int indexOfNewElement = size;
        int parentIndex = indexOfNewElement/2;
        while ((minHeap[indexOfNewElement]<minHeap[parentIndex]) && indexOfNewElement>1){
            int temp = minHeap[indexOfNewElement];
            minHeap[indexOfNewElement] = minHeap[parentIndex];
            minHeap[parentIndex] = temp;
            indexOfNewElement = parentIndex;
            parentIndex = parentIndex/2;
        }
    }

    public String toString() {
        if (size == 0) {
            return "No element!";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 1; i <= size; i++) {
                sb.append(minHeap[i]);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            return sb.toString();
        }
    }

    public int peek(){
        return minHeap[1];
    }

    public int pop(){
        if(size<1){
            System.out.println("Heap is Empty");
            return Integer.MAX_VALUE;
        } else {
            int removeElement = minHeap[1];
            int index = 1;
            size--;
            minHeap[1] = minHeap[size];
            while (index<=size/2) {
                int left = index * 2;
                int right = index * 2 + 1;
                if (minHeap[index] > minHeap[left] || minHeap[index] > minHeap[right]) {
                    if (minHeap[left] < minHeap[right]) {
                        int temp = minHeap[index];
                        minHeap[index] = minHeap[left];
                        minHeap[left] = temp;
                        index = left;
                    } else {
                        int temp = minHeap[index];
                        minHeap[index] = minHeap[right];
                        minHeap[right] = temp;
                        index = right;
                    }
                } else {
                    break;
                }
            }
            return removeElement;
        }
    }

    public static void main(String[] args) {
        // Test case
        MinHeap minHeap = new MinHeap(3);
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(2);
        // [1,3,2]
        System.out.println(minHeap.toString());
        // 1
        System.out.println(minHeap.peek());
        // 1
        System.out.println(minHeap.pop());
        // [2, 3]
        System.out.println(minHeap.toString());
        minHeap.add(4);
        // Add too many elements
        minHeap.add(5);
        // [2,3,4]
        System.out.println(minHeap.toString());
    }
}
