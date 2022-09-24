package strings;

import java.util.HashSet;
import java.util.Set;
/**
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsSet = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            jewelsSet.add(jewel);
        }
        int result = 0;
        for(char stone:stones.toCharArray()){
            if(jewelsSet.contains(stone))
                result++;
        }
        return result;
    }
}
