package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * Input: s = "ABAB", k = 2
 * Output: 4
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int stringLength = s.length();
        int lengthOfMaxSubstring = 0;
        int start = 0;
        Map<Character, Integer> charFreq = new HashMap<>();
        int mostFreqChar = 0;

        for (int end = 0; end < stringLength; ++end) {
            char currentChar = s.charAt(end);

            charFreq.put(currentChar, charFreq.getOrDefault(currentChar, 0) + 1);

            mostFreqChar = Math.max(mostFreqChar, charFreq.get(currentChar));

            if (end - start + 1 - mostFreqChar > k) {
                charFreq.put(s.charAt(start), charFreq.get(s.charAt(start)) - 1);
                start += 1;
            }

            lengthOfMaxSubstring = Math.max(lengthOfMaxSubstring, end - start + 1);
        }

        return lengthOfMaxSubstring;
    }
}
