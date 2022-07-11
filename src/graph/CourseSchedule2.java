package graph;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
 * you must take course bi first if you want to take course ai.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them.
 * If it is impossible to finish all courses, return an empty array.
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 */
public class CourseSchedule2 {
    //Using Topological Sort to solve the problem.
    //Time Complexity: O(V+E)
    //Space Complexity: O(V+E)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean isPossible = true;
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        //Traverse through the prerequisites array and populate the adjacency List and indegree array
        for (int i = 0; i < prerequisites.length; i++) {
            int des = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> list = adjList.getOrDefault(src,new ArrayList<>());
            list.add(des);
            adjList.put(src,list);
            indegree[des]+= 1;
        }

        // Add all vertices with 0 in-degree to the queue
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i]==0)
                queue.add(i);
        }

        int i=0;
        //Takes from queue and add in topo array. Reduce the indegree of each adjacent vertices by 1.
        //If indegree of adjacent vertex is zero then add to the queue.
        while (!queue.isEmpty()){
            int node = queue.poll();
            topologicalOrder[i++]=node;
            if(adjList.containsKey(node)){
                for(Integer neighbour : adjList.get(node)){
                    indegree[neighbour]--;
                    if(indegree[neighbour] ==0)
                        queue.add(neighbour);
                }
            }
        }
        if(i==numCourses)
            return topologicalOrder;
        return new int[0];
    }
}
