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

    /**
     * Insert (word): This inserts a word into the trie.
     * @param word
     * In this function, we take a word as input. We begin from the root node and iterate over the string one character at a time.
     * At each node, we check whether or not a child node with the character is present.
     * If it’s not present, a new node is initialized. For the last character of the word, we also set the boolean variable to TRUE
     * for the corresponding node.
     */
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

    /**
     * This searches the given word in the trie and returns TRUE, if found. Otherwise, return FALSE.
     * @param word
     * @return
     */
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

    /**
     * This searches the given prefix in the trie and returns TRUE, if found. Otherwise, return FALSE.
     * @param prefix
     * @return
     */
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
