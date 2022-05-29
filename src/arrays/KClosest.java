package arrays;

import java.util.Arrays;

public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points,(a,b)->distance(a)-distance(b));
        return Arrays.copyOf(points, k);
    }

    private int distance(int[] point){
        return point[0]*point[0]+point[1]*point[1];
    }
}
