package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/map-sum-pairs/
 * Design a map that allows you to do the following:
 *
 * Maps a string key to a given value.
 * Returns the sum of the values that have a key with a prefix equal to a given string.
 */
public class MapSumPairs {
    Map<String,Integer> map;

    class TrieNode{
        public int score;
        public Map<Character, TrieNode> childrenMap = new HashMap<>();
    }
    private TrieNode root;

    public MapSumPairs() {
        map = new HashMap<>();
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key,0);
        map.put(key,val);
        TrieNode cur = root;
        cur.score+=delta;
        for(char chr :  key.toCharArray()){
            cur.childrenMap.putIfAbsent(chr,new TrieNode());
            cur = cur.childrenMap.get(chr);
            cur.score+=delta;
        }
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for(char chr :prefix.toCharArray()){
            cur = cur.childrenMap.get(chr);
            if(cur==null) return 0;
        }
        return cur.score;
    }
}
