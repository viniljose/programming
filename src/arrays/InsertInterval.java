package arrays;

import java.util.LinkedList;
/**
 * https://leetcode.com/problems/insert-interval/
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the
 * start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given
 * an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
 * still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int index = 0;
        int n=intervals.length;
        LinkedList<int[]> output = new LinkedList<>();
        while(index<n && newStart >intervals[index][0])
            output.add(intervals[index++]);
        int[] temp = new int[2];
        if(output.isEmpty() || output.getLast()[1]<newStart)
            output.add(newInterval);
        else {
            temp = output.removeLast();
            temp[1]=Math.max(temp[1],newEnd);
            output.add(temp);
        }
        while (index<n){
            temp = intervals[index++];
            if(output.getLast()[1] < temp[0])
                output.add(temp);
            else {
                int[] temp2 = output.removeLast();
                temp2[1]=Math.max(temp[1],temp2[1]);
                output.add(temp2);
            }
        }
        return output.toArray(new int[output.size()][2]);
    }
}
