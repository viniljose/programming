package hashtable;

import java.util.LinkedList;
import java.util.List;

public class MyHashMap {
    class Entry<K,V> {
        public K key;
        public V value;
        public Entry(K key,V value){
            this.key = key;
            this.value = value;
        }
    }
    class Bucket {
        public List<Entry<Integer,Integer>> container;
        public Bucket(){
            container = new LinkedList<>();
        }
        public Integer get(Integer key){
            for (Entry entry : container){
                if(entry.key.equals(key)){
                    return (Integer) entry.value;
                }
            }
            return -1;
        }
        public void add(Integer key ,Integer value){
            boolean exists = false;
            for (Entry entry : container){
                if(entry.key.equals(key)){
                    entry.value = value;
                    exists = true;
                }
            }
            if(!exists){
                Entry entry = new Entry(key,value);
                container.add(entry);
            }
        }
        public void remove(Integer key){
            for (Entry entry : container) {
                if (entry.key.equals(key)) {
                    container.remove(entry);
                    break;
                }
            }
        }

    }

    private int bucketSize = 2069;
    private Bucket[] buckets;

    public MyHashMap(){
        buckets = new Bucket[bucketSize];
        for (int i = 0; i < bucketSize; i++) {
            buckets[i] = new Bucket();
        }
    }
    private int hashValue(int key){
        return key % bucketSize;
    }
    public int get(int key){
        return buckets[hashValue(key)].get(key);
    }
    public void put(int key ,int value){
        buckets[hashValue(key)].add(key,value);
    }
    public void remove(int key) {
        buckets[hashValue(key)].remove(key);
    }

}
