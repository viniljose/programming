package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/boats-to-save-people/
 * You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats
 * where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time,
 * provided the sum of the weight of those people is at most limit.
 * Return the minimum number of boats to carry every given person.
 * Input: people = [1,2], limit = 3
 * Output: 1
 * Input: people = [3,2,2,1], limit = 3
 * Output: 3
 */
public class BoatsToSavePeople {

    /**
     * If the heaviest person can share a boat with the lightest person, then do so.
     * Otherwise, the heaviest person can't pair with anyone, so they get their own boat.
     */
    public int numRescueBoats(int[] people, int limit) {
        int ans =0;
        Arrays.sort(people);
        int i=0,j=people.length-1;
        while (i<=j){
            ans++;
           if(people[i]+people[j]<=limit)
               i++;
           j--;
        }
        return ans;
    }
}
