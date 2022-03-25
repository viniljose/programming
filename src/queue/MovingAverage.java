package queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    int windowSize;
    int length;
    Queue queue;
    int windowSum;

    public MovingAverage(int size) {
        windowSize = size;
        length = 0;
        queue = new LinkedList<Integer>();
        windowSum = 0;
    }

    public double next(int val) {
        length++;
        queue.add(val);
        int tail = 0;
        if(length>windowSize)
            tail = (int)queue.poll();
        windowSum = windowSum - tail + val;
        return windowSum * 1.0 / Math.min(windowSize,length);
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}
