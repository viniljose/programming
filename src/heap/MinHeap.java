package heap;

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
        if(size>capacity){
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

    public static void main(String[] args) {
        // Test case
        MinHeap minHeap = new MinHeap(3);
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(2);
        // [1,3,2]
        System.out.println(minHeap.toString());
        // 1
        //System.out.println(minHeap.peek());
        // 1
       // System.out.println(minHeap.pop());
        // [2, 3]
       // System.out.println(minHeap.toString());
       // minHeap.add(4);
        // Add too many elements
       // minHeap.add(5);
        // [2,3,4]
       // System.out.println(minHeap.toString());
    }
}
