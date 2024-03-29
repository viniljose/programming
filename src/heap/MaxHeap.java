package heap;

public class MaxHeap {
    private int size;
    private int capacity;
    private int[] maxHeap;
    public MaxHeap(int capacity){
        this.size = 0;
        this.capacity = capacity;
        maxHeap = new int[capacity+1];
        maxHeap[0] = 0;
    }
    public void add(int element){
        if(size == capacity){
            System.out.println("Heap is full");
            return;
        }
        size++;
        maxHeap[size] = element;
        int index = size;
        int parent = size/2;
        while (maxHeap[index]>maxHeap[parent] && index>1){
            int temp = maxHeap[index];
            maxHeap[index] = maxHeap[parent];
            maxHeap[parent] = temp;
            index = parent;
            parent = index/2;
        }
    }
    public int peek(){
        return maxHeap[1];
    }
    public int pop(){
        if(size<1){
            System.out.println("Heap is Empty");
            return Integer.MAX_VALUE;
        }
        int element = maxHeap[1];
        maxHeap[1] = maxHeap[size];
        size--;
        int index = 1;

        while (index<=size/2){
            int left = index*2;
            int right = index*2+1;
            if (maxHeap[left]>maxHeap[index] || maxHeap[right]>maxHeap[index]){
                if(maxHeap[left]> maxHeap[right]) {
                    int temp = maxHeap[index];
                    maxHeap[index] = maxHeap[left];
                    maxHeap[left] = temp;
                    index = left;
                } else {
                    int temp = maxHeap[index];
                    maxHeap[index] = maxHeap[right];
                    maxHeap[right] = temp;
                    index = right;
                }
            } else {
                break;
            }
        }
        return element;
    }

    public String toString() {
        if (size == 0) {
            return "No element!";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 1; i <= size; i++) {
                sb.append(maxHeap[i]);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // Test case
        MaxHeap maxheap = new MaxHeap(5);
        maxheap.add(1);
        maxheap.add(2);
        maxheap.add(3);
        // [3,1,2]
        System.out.println(maxheap.toString());
        // 3
        System.out.println(maxheap.peek());
        // 3
        System.out.println(maxheap.pop());
        System.out.println(maxheap.pop());
        System.out.println(maxheap.pop());
        // No element
        System.out.println(maxheap.toString());
        maxheap.add(4);
       
        maxheap.add(5);
        // [5,4]
        System.out.println(maxheap.toString());
    }
}
