package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character 
 * in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Input: s = "a", t = "aa"
 * Output: ""
 */
public class MinumumWindowSubstring {
    
    //Time complexity : O(length of s +length of t)
    //Space complexity : O(length of s +length of t)
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0)
        return "";
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dict.getOrDefault(t.charAt(i), 0);
            dict.put(t.charAt(i), count + 1);
        }
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        int left=0,right=0;
        int formed = 0;
        int required = dict.size();
        int[] minWindow = {-1,0,0};
        while(right < s.length()){
            char c = s.charAt(right);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count+1);
            if(dict.containsKey(c) && windowCounts.get(c).intValue()==dict.get(c).intValue()){
                formed++;
            }
            while(left <= right && formed==required){
                c= s.charAt(left);
                if (minWindow[0] == -1 || right - left + 1 < minWindow[0]) {
                    minWindow[0] = right - left + 1;
                    minWindow[1] = left;
                    minWindow[2] = right;
                }
                windowCounts.put(c, windowCounts.get(c).intValue()-1);
                left++;
                if(dict.containsKey(c) && windowCounts.get(c).intValue()<dict.get(c).intValue()){
                    formed--;
                }

            }
            right++;
        }
        return minWindow[0] == -1 ? "" : s.substring(minWindow[1], minWindow[2] + 1);
    }
}
