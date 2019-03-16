package algoritham;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given there are n meetings to held ,each meeting having a start and end time as
 *  ST1,ET1 ..... STn,ETn, Find the minimum number of rooms needed to accommodate all the meetings?
 *
 */
public class Meetings {
	
	public int minimumRooms(Map meetings){
		Float[] starts = new Float[meetings.size()];
		meetings.keySet().toArray(starts);
		Arrays.sort(starts);
		Float[] ends = new Float[meetings.size()];
		meetings.values().toArray(ends);
		Arrays.sort(ends);
		return minimumRoomsNeeded(starts, ends,meetings.size());
	}
	
	private int minimumRoomsNeeded(Float[] starts,Float[]ends,int n){
		int minimum=1,temp=1;
		int i=1,j=0;
		while(i<n&&j<n){
			if(starts[i]<ends[j]){
				temp++;
				i++;
				if(temp>minimum)
					minimum=temp;
				
			} else {
				temp--;
				j++;
			}
			
		}
		
		return minimum;
	}

	public static void main(String[] args) {
		Meetings mts = new Meetings();
		Map<Float,Float> meetings1 = new HashMap<Float,Float>();
		meetings1.put(8.30f, 10.30f);
		meetings1.put(9.00f, 14.00f);
		meetings1.put(10.00f, 11.00f);
		meetings1.put(12.00f, 13.30f);
		meetings1.put(13.00f, 15.30f);
		System.out.println(mts.minimumRooms(meetings1));
		
		Map<Float,Float> meetings2 = new HashMap<Float,Float>();
		meetings2.put(8.30f, 10.30f);
		meetings2.put(9.00f, 14.00f);
		System.out.println(mts.minimumRooms(meetings2));
		
		Map<Float,Float> meetings3 = new HashMap<Float,Float>();
		meetings3.put(8.00f, 10.00f);
		meetings3.put(11.00f, 14.00f);
		System.out.println(mts.minimumRooms(meetings3));
	}

}
