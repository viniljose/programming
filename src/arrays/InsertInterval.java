package arrays;

import java.util.LinkedList;
/**
 * https://leetcode.com/problems/insert-interval/
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
