package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fruit-into-baskets/
 *  Longest Substring with K Distinct Characters where K=2.
 */
public class FruitsToBasket {

    public int totalFruit(int[] fruits) {
        int size = fruits.length;
        Map<Integer,Integer> fruitFrequncyMap = new HashMap<>();
        int start=0;
        int maxLength = 0;
        for (int end = 0; end < size; end++) {
            fruitFrequncyMap.put(fruits[end],fruitFrequncyMap.getOrDefault(fruits[end],0)+1);
            while (fruitFrequncyMap.size()>2){
                fruitFrequncyMap.put(fruits[start],fruitFrequncyMap.get(fruits[start])-1);
                if(fruitFrequncyMap.get(fruits[start])==0)
                    fruitFrequncyMap.remove(fruits[start]);
                start++;
            }
            maxLength=Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }
}
