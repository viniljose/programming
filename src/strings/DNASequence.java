package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur
 * more than once in a DNA molecule. You may return the answer in any order.
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 */
public class DNASequence {

    public List<String> findRepeatedDnaSequences(String s) {
        return findRepeatedDnaSequences(s,10);
    }

    private List<String> findRepeatedDnaSequences(String s, int k) {
        Set<String> result =new HashSet<>();

        int len = s.length();
        if(len<=k){
            return new ArrayList<>();
        }
        List<String> allSubstring =new ArrayList<>();
        for (int i = 0; i < len-k+1; i++) {
            String curr = s.substring(i,i+k);
            if(allSubstring.contains(curr))
                result.add(curr);
            else
                allSubstring.add(curr);
        }
        return new ArrayList<String>(result);
    }
}
