package strings;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int length = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,-1);
            } else {
                map.put(c,i);
            }
        }
        for (int i = 0; i < length; i++) {
            if(map.get(s.charAt(i))!=-1)
                return map.get(s.charAt(i));
        }
        return -1;
    }
}
