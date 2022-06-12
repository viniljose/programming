package integers;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Input: n = 2 Output: 2
 * Input: n = 3 Output: 3
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        return climb(0,n);
    }

    private int climb(int i,int n){
        if(i>n) return 0;
        if(i==n) return 1;
        return climb(i+1,n)+climb(i+2,n);
    }

    public int climbStairsMemo(int n) {
        int[] memo = new int[n+1];
        return climbMemo(0,n,memo);
    }
    private int climbMemo(int i,int n,int[] memo){
        if(i>n) return 0;
        if(i==n) return 1;
        if(memo[i]>0)
            return memo[i];
        memo[i] = climbMemo(i+1,n,memo)+climbMemo(i+2,n,memo);
        return memo[i];
    }
}
