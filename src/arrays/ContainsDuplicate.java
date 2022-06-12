package arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> content = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            if(content.contains(element))
                return true;
            else
                content.add(element);
        }
        return false;
    }
}
