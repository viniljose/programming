package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/find-the-ordering-of-tasks-from-given-dependencies/
 * There are a total of n tasks you have to pick, labeled from 0 to n-1. Some tasks may have prerequisites tasks,
 * for example to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]
 * Given the total number of tasks and a list of prerequisite pairs, return the ordering of tasks you should pick
 * to finish all tasks.
 * Input: 2, [[1, 0]]
 * Output: [0, 1]
 */
public class OrderingDependencies {

    private ArrayList<HashSet<Integer>>  makeGraph(int numTasks, int[][] prerequisites)
    {
        ArrayList<HashSet<Integer>> graph = new ArrayList<>(numTasks);
        for (int i = 0; i < numTasks; i++) {
            graph.add(new HashSet<>());
        }
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }
        return graph;
    }

    private int[] computeIndegree(ArrayList<HashSet<Integer> > graph)
    {
        int[] degrees = new int[graph.size()];
        for (HashSet<Integer> childs: graph){
            for (int child: childs){
                degrees[child]++;
            }
        }
        return degrees;
    }

    public ArrayList<Integer> findOrder(int numTasks, int[][] prerequisites)
    {
        // Create an adjacency list
        ArrayList<HashSet<Integer>> graph = makeGraph(numTasks,prerequisites);

        // Find vertices of zero degree
        int[] inDegrees = computeIndegree(graph);
        Queue<Integer> zero = new LinkedList<>();
        for (int i = 0; i < numTasks; i++) {
            if(inDegrees[i]==0)
                zero.add(i);
        }

        // Find vertices in topological order
        // starting with vertices of 0 degree
        // and reducing degrees of adjacent.
        ArrayList<Integer> toposort
                = new ArrayList<Integer>();
        for (int i = 0; i < numTasks; i++) {
            if(zero.isEmpty())
                return new ArrayList<Integer>();
            int element = zero.peek();
            zero.poll();
            toposort.add(element);
            for(int child : graph.get(element)){
                if(--inDegrees[child]==0)
                    zero.add(child);
            }
        }
        return toposort;
    }
}
