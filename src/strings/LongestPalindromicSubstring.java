package strings;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        String res = null;
        //dp(i, j) represents whether s(i ... j) can form a palindromic substring,
        //dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                 //j-i<3 for 1,2 3 char length strings, first and last character needs to be the same
                 //For strings above 3 chars, string of i+1,j-1 needs to be a palindrome
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindrome("babad"));
    }
}

