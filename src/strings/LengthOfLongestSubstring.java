package strings;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LengthOfLongestSubstring {

    // brutforce method
    //Time complexity : O(n^3)
    //Space complexity : O(min(n, m))
    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        int length = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if(checkNoRepetition(s, i, j)){
                    length = Math.max(length,j-i+1);
                }
            }
        }
        return length;
    }

    private boolean checkNoRepetition(String s, int start, int end) {
        int[] chars = new int[128];
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            if(chars[c]>1)
            return false;
        }
        return true;
    } 

    //Time complexity : O(n)
    //Space complexity : O(min(n, m))
    public int lengthOfLongestSubstringSW(String s) {
        int[] chars = new int[128];
        int left=0,right =0,res=0;
        while(right<s.length()){
            char c = s.charAt(right);
            chars[c]++;
            while(chars[c]>1){
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }
            res = Math.max(res, right-left+1);
            right++;
        }
        return res;
    }

    public static void main(String[] args){
        LengthOfLongestSubstring length = new LengthOfLongestSubstring();
        System.out.println(length.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(length.lengthOfLongestSubstringSW("abcabcbb"));
    }
}