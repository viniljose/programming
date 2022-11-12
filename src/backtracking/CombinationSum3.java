package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice,
 * and the combinations may be returned in any order.
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 */
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> combinations = new LinkedList<>();
        this.backtrack(n,k,combinations,0,result);
        return result;
    }

    private void backtrack(int remains,int k,LinkedList<Integer> combinations,int nextStart,List<List<Integer>> result ){
        if(remains==0 && combinations.size()==k){
            result.add(new ArrayList<Integer>(combinations));
            return;
        } else if(remains<0 || combinations.size()==k){
            return;
        }
        for (int i = nextStart; i < 9; i++) {
            combinations.add(i+1);
            backtrack(remains-i-1,k,combinations,i+1,result);
            combinations.removeLast();
        }
    }

}
