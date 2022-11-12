package backtracking;

import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> combinations = new LinkedList<>();
        Map<Integer,Integer> counterMap = new HashMap<>();
        //Arrays.stream(candidates).map(a->counterMap.containsKey(a)?counterMap.put(a,counterMap.get(a)+1):counterMap.put(a,1));
        for (int candidate : candidates) {
            if (counterMap.containsKey(candidate))
                counterMap.put(candidate, counterMap.get(candidate) + 1);
            else
                counterMap.put(candidate, 1);
        }

        List<int[]> counterList = new ArrayList<>();
        counterMap.forEach((key,value)->{counterList.add(new int[]{key, value});});
        backtrack(result,combinations,counterList,target,0);
        return result;
    }

    private void backtrack( List<List<Integer>> result,LinkedList<Integer> combinations,List<int[]> counterList,int remains,
                            int current){
        if(remains<=0){
            if(remains==0)
                result.add(new ArrayList<>(combinations));
            return;
        }
        for (int i = current; i < counterList.size(); i++) {
            int[] entry = counterList.get(i);
            Integer candidate = entry[0];
            Integer freq = entry[1];
            if(freq<=0)
                continue;
            combinations.addLast(candidate);
            counterList.set(i,new int[]{candidate,freq-1});
            backtrack(result,combinations,counterList,remains-candidate,i);
            counterList.set(i,new int[]{candidate,freq});
            combinations.removeLast();
        }
    }
}
