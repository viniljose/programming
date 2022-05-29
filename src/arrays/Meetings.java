package arrays;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals intervals where intervals[i] =
 * [starti, endi],
 * return the minimum number of conference rooms required.
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 */
public class Meetings {

    // Time complexity : O(nlogn)
    // Space complexity : O(n)
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0)
        return 0;
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startPointer = 0, endPointer=0,rooms=0;
        while(startPointer < intervals.length){
        if(start[startPointer]>=end[endPointer]){
            rooms--;
            endPointer++;
        }
        rooms++;
        startPointer++;
    }

    return rooms;
}
}
