package strings;

import java.util.HashMap;

public class LongestSubstringTwoDistinct {

     //Time complexity : O(n)
    //Space complexity : O(1)
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) return n;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();        
        int max_len = 2;
        while(right<n){
            char c = s.charAt(right);
            int count = hashmap.getOrDefault(c, 0);
            hashmap.put(c, ++count);           
            while(left<= right && hashmap.size()>2){
                max_len = Math.max(max_len, right - left);
                c=s.charAt(left);
                int cnt = hashmap.getOrDefault(c, 0);
                if(cnt>1)
                hashmap.put(c, cnt-1);
                else
                hashmap.remove(c);
                left++;
            }            
            right++;
        }
        return  Math.max(max_len, right - left);
    }
}
