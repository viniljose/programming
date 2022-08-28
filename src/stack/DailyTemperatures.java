package stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is
 * the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        //int array to holding index same as temperatures array with answer
        int[] answer = new int[n];

        //stack holding the index of temperature array
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int currentTemp = temperatures[i];

            while (!stack.isEmpty()&& temperatures[stack.peek()]<currentTemp){
                int previous = stack.pop();
                answer[previous] = i-previous;
            }
            stack.push(i);
        }
        return answer;
    }
}
