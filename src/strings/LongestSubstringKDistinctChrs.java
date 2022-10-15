package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
 * Input: s = "eceba", k = 2
 * Output: 3
 */
public class LongestSubstringKDistinctChrs {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int size = s.length();
        if(size*k==0)
            return 0;
        int start=0;
        int max=0;
        Map<Character,Integer> chrFrequencyMap = new HashMap<>();

        for (int end = 0; end < size; end++) {
            char right = s.charAt(end);
            chrFrequencyMap.put(right,chrFrequencyMap.getOrDefault(right,0)+1);
            while (chrFrequencyMap.size()>k){
                char left = s.charAt(start);
                chrFrequencyMap.put(left,chrFrequencyMap.get(left)-1);
                if (chrFrequencyMap.get(left)==0)
                    chrFrequencyMap.remove(left);
                start++;
            }
            max=Math.max(max,end-start+1);
        }
        return max;
    }
}
