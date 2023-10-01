package strings;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * Input: s = "abca"
 * Output: true
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int len = s.length();
        int start =0,end=len-1;
        while (start<end){
            if(s.charAt(start)==s.charAt(end))
            {
                start++;
                end--;
            } else {
                return validPalindrome1(s,start,end-1)||validPalindrome1(s,start+1,end);
            }
        }
        return true;
    }
    private boolean validPalindrome1(String s,int start,int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
