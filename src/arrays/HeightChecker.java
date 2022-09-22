package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/height-checker/
 * A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line
 * in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i]
 * is the expected height of the ith student in line.
 *
 * You are given an integer array heights representing the current order that the students are standing in.
 * Each heights[i] is the height of the ith student in line (0-indexed).
 *
 * Return the number of indices where heights[i] != expected[i].
 * Input: heights = [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * heights:  [1,1,4,2,1,3]
 * expected: [1,1,1,2,3,4]
 * Indices 2, 4, and 5 do not match.
 */
public class HeightChecker {
    public static void main(String[] args) {
        int[] heights = new int[] {1,1,4,2,1,3};
        HeightChecker heightChecker =new HeightChecker();
        int result = heightChecker.heightChecker(heights);
        System.out.println("--------->"+result);

        int[] heights1 = new int[] {5,1,2,3,4};
        result = heightChecker.heightChecker(heights1);
        System.out.println("--------->"+result);

        int[] heights2 = new int[] {1,2,3,4,5};
        result = heightChecker.heightChecker(heights2);
        System.out.println("--------->"+result);
    }

    public int heightChecker(int[] heights) {
        if (heights == null || heights.length == 0 ) {
            return 0;
        }
        if (heights.length == 1) {
            return 1;
        }

        // generate expected array, use sorting.
        //Compare each element,if they are not equal increase the tracker
        int[] expected = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            expected[i] = heights[i];
        }
        Arrays.sort(expected);

        int tracker = 0;
        for (int i = 0; i < heights.length; i++) {
            if(expected[i]!= heights[i])
                tracker++;
        }

        return tracker;
    }
}
