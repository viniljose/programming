package arrays;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals 'intervals' where intervals[i] = [starti, endi],
 * return the minimum number of conference rooms required.
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 */
public class MeetingRooms2 {
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
        //When we encounter an ending event, that means that some meeting that started earlier has ended now.
        // We are not really concerned with which meeting has ended. All we need is that some meeting ended thus
        // making a room available.
        //If no meeting has ended by the start of current meeting ,then we allocate a room.
        //If a meeting was ended by the time of current meeting start, then we can re-use the room.
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
