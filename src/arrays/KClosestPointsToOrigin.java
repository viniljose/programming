package arrays;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * Given an array of points in a 2D plane, find ‘K’ closest points to the origin.
 * Input: points = [[1,2],[1,3]], K = 1
 * Output: [[1,2]]
 * The Euclidean distance between (1, 2) and the origin is sqrt(5).
 */
public class KClosestPointsToOrigin {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distFromOrigin() {
            // ignoring sqrt
            return (x * x) + (y * y);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((n1,n2)->n2.distFromOrigin()-n1.distFromOrigin());
        Point[] pointArray = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            pointArray[i]= new Point(points[i][0],points[i][1]);
        }
        for (int i = 0; i < points.length; i++) {
            maxHeap.add(pointArray[i]);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        Point[] arr =  maxHeap.toArray(new Point[points.length]);
        int[][] result = new int[points.length][2];
        for (int i = 0; i < points.length; i++) {
            result[i][0] = arr[i].x;
            result[i][1]=arr[i].y;
        }
        return result;
    }

       /* public int[][] kClosest(int[][] points, int k) {
            Arrays.sort(points,(a,b)->distance(a)-distance(b));
            return Arrays.copyOf(points, k);
        }

        private int distance(int[] point){
            return point[0]*point[0]+point[1]*point[1];
        }*/
}
