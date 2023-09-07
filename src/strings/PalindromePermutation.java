package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/palindrome-permutation/description/
 * Given a string s, return true if a permutation of the string could form a
 * palindrome and false otherwise.
 *  Input: s = "code"
 * Output: false
 * Input: s = "carerac"
 * Output: true
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        Set<Character> keys = map.keySet();
        int count = 0;
        for (Character key : keys){
            count+= map.get(key)%2;
        }
        return count<=1;
    }
}
