package trie;

import java.util.*;

/**
 * https://leetcode.com/problems/design-search-autocomplete-system/
 *
 */
public class AutoCompleteSystem {
    class TrieNode{
        Map<Character,TrieNode> children = new HashMap<>();
        Map<String,Integer> counts = new HashMap<>();
    }
    private TrieNode root;
    private String prefix;

    public AutoCompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            addToTrie(sentences[i],times[i]);
        }
    }
    private void addToTrie(String sentence, int count) {
        TrieNode curr = root;
        for(char chr:sentence.toCharArray()){
            if(!curr.children.containsKey(chr))
                curr.children.put(chr,new TrieNode());
            curr = curr.children.get(chr);
            curr.counts.put(sentence,curr.counts.getOrDefault(sentence,0)+count);
        }
    }

    public List<String> input(char c) {
        if(c == '#'){
            addToTrie(prefix,1);
            prefix = "";
            return new ArrayList<>();
        }
        prefix+=c;
        TrieNode curr = root;
        for (char ch :prefix.toCharArray()){
            if(!curr.children.containsKey(ch))
                return new ArrayList<>();
            curr = curr.children.get(ch);
        }
        Map<String ,Integer> counts = curr.counts;
        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (a,b)->(counts.get(a)==counts.get(b)?b.compareTo(a):counts.get(a)-counts.get(b))
        );
        for (String key : counts.keySet()){
            minHeap.offer(key);
            if(minHeap.size()>3)
                minHeap.remove();
        }
        List<String> result = new ArrayList<>();

        while (minHeap.size()>0)
            result.add(0,minHeap.remove());
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"i love you", "island", "iroman", "i love leetcode"};
        int[] counts = {5, 3, 2, 2};
        AutoCompleteSystem auto = new AutoCompleteSystem(strings,counts);
        System.out.println(auto.input('i'));
        System.out.println(auto.input(' '));
        System.out.println(auto.input('a'));
        System.out.println(auto.input('#'));
    }
}
