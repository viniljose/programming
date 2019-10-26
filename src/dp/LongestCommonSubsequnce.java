package dp;

/**
 * 
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 *LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 *LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LongestCommonSubsequnce {
	
	public String longestCommonSubsequence(String x,String y) {
		int m = x.length();
		int n = y.length();
		int[][] lcs = new int[m+1][n+1];
		
		//initialize the table
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(x.charAt(i)==y.charAt(j))
					lcs[i+1][j+1]=1+lcs[i][j];
				else
					lcs[i+1][j+1]= Math.max(lcs[i+1][j], lcs[i][j+1]);
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++)
				System.out.print(lcs[i][j] + " ");
			System.out.println();
		}
		
		StringBuffer lcsString = new StringBuffer();
		
		while(m!=0 && n!=0) {
			
			if(lcs[m][n]==lcs[m-1][n])
				m--;
			else if (lcs[m][n]==lcs[m][n-1])
				n--;
			else {
				assert x.charAt(m-1)==y.charAt(n-1);
				lcsString.append(x.charAt(m-1));
				m--;
				n--;
				
			}
				
		}
		return lcsString.reverse().toString();
	}
	
	public static void main(String[] args) {
		LongestCommonSubsequnce lcs = new LongestCommonSubsequnce();
		//System.out.println(lcs.longestCommonSubsequence("ABCDGH", "AEDFHR"));
		System.out.println(lcs.longestCommonSubsequence("AGGTAB", "GXTXAYB")); 
	}

}
