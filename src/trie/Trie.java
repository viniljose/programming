package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Length of the word is N.time complexity of all insert, search and startsWith methods will be O(N).
 * If we have M words to insert in total and the length of words is at most N & there are maximum K different characters.
 * So each node will maintain a map whose size is at most K.
 * space complexity will be O(M*N*K)
 */
public class Trie {
    class TrieNode{
        public boolean isWord;
        public Map<Character,TrieNode> childrenMap = new HashMap<>();
    }
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c= word.charAt(i);
            if(cur.childrenMap.get(c)==null)
                cur.childrenMap.put(c,new TrieNode());
            cur = cur.childrenMap.get(c);
        }
        cur.isWord=true;
    }
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.childrenMap.get(c)==null)
                return false;
            cur = cur.childrenMap.get(c);
        }
        return cur.isWord;
    }
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.childrenMap.get(c)==null)
                return false;
            cur = cur.childrenMap.get(c);
        }
        return true;
    }
}
