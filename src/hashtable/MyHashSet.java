package hashtable;

import java.util.LinkedList;

public class MyHashSet {
    private int bucketSize = 769;
    private Bucket[] buckets;

    public MyHashSet() {
        buckets = new Bucket[bucketSize];
        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = new Bucket();
        }
    }
    private int hashValue(int key){
        return key % bucketSize;
    }

    public void add(int key) {
        buckets[hashValue(key)].add(key);
    }

    public void remove(int key) {
        buckets[hashValue(key)].remove(key);
    }

    public boolean contains(int key) {
        return buckets[hashValue(key)].contains(key);
    }

    class Bucket{
        private LinkedList<Integer> container;
        public Bucket(){
            container = new LinkedList<>();
        }
        public void add(Integer key){
            int index = container.indexOf(key);
            if(index == -1)
                container.addFirst(key);
        }
        public void remove(Integer key){
            container.remove(key);
        }
        public boolean contains(Integer key){
            int index = container.indexOf(key);
            return  (index != -1);
        }
    }
}
