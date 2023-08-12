package strings;

/**
 * https://leetcode.com/problems/palindromic-substrings/description/
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 * Input: s = "aaa"
 * Output: 6
 */
public class PalindromicSubstrings {

    //Check All substring whether they are palindrome.Not recommended as o(n3) solution.
    public int countSubstrings1(String s) {
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                count+=isPallindrome(s,i,j)?1:0;
            }

        }
        return count;
    }

    private boolean isPallindrome(String s, int start, int end){
        while (start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    //o(n2) DP solution
    public int countSubstrings(String s) {
        int n = s.length();
        if(n<=0)
            return 0;
        //array representing the dp(i,j) is true if substring from 1 to j is palindrome
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        
        //all substring with length 1 is palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i]=true;
            ans++;
        }
        
        //Case2 where substring of length 2
        for (int i = 0; i < n-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)) {
                dp[i][i + 1] = true;
                ans++;
            }
        }

        //Case3 substring from 3 to n
        for (int length = 3; length <=n; length++) {
            for (int i = 0,j=i+length-1; j < n; i++,j++) {
                dp[i][j]=dp[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
                if(dp[i][j])
                    ans++;
            }

        }
        return ans;
    }

}
