package arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/meeting-rooms/description/
 * Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: false
 * Input: intervals = [[7,10],[2,4]]
 * Output: true
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        for (int i = 0; i < intervals.length-1; i++) {
            if(intervals[i][1]>intervals[i+1][0])
                return false;
        }
        return true;
    }
}
