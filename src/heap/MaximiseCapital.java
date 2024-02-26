package heap;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/ipo/description/
 * A busy investor with an initial capital, w, needs an automated investment program.
 * They can select k distinct projects from a list of n projects with corresponding capitals requirements
 * and expected profits. For a given project i, its capital requirement is capitals[i],
 * and the profit it yields is profits[i].
 *
 * The goal is to maximize their cumulative capital by selecting a maximum of k distinct projects to invest in,
 * subject to the constraint that the investor’s current capital must be greater than or equal to the capital
 * requirement of all selected projects.
 *
 * When a selected project from the identified ones is finished, the pure profit from the project,
 * along with the starting capital of that project is returned to the investor.
 * This amount will be added to the total capital held by the investor.
 * Now, the investor can invest in more projects with the new total capital.
 * It is important to note that each project can only be invested once.
 */
public class MaximiseCapital {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n= capital.length;
        int currentCapital = w;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{capital[i],i});
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b)->b-a);
        int i=0;
        while (i<k){
            while (!minHeap.isEmpty()&&(minHeap.peek()[0]<= currentCapital)){
                int[] element = minHeap.poll();
                maxHeap.offer(profits[element[1]]);
            }
            if(maxHeap.isEmpty())
                break;
            currentCapital+=maxHeap.poll();
            i++;
        }
        return currentCapital;
    }
}
