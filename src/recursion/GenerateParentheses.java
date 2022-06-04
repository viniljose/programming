package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans =  new ArrayList<>();
        backtrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if(cur.length()==2*max){
            ans.add(cur.toString());
            return;
        }
        if(open<max){
            cur.append('(');
            backtrack(ans,cur,open+1,close,max);
            cur.deleteCharAt(cur.length()-1);
        }
        if(close<open){
            cur.append(')');
            backtrack(ans,cur,open,close+1,max);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses para =  new GenerateParentheses();
        System.out.println(para.generateParenthesis(2));
    }
}
