package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * Determine if there is a valid path that exists from vertex source to vertex destination
 * Use a DFS using adjacency List with a stack and visited array.
 * Time Complexity: O(V+E)
 * Space Complexity: O(V+E).
 */
public class PathExists {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adjList= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Stack<Integer> stack =new Stack<>();
        stack.push(start);
        boolean[] visited = new boolean[n];
        while (!stack.isEmpty()){
            int v = stack.pop();
            if(v==end) return true;
            visited[v]=true;
            for (int neighbour : adjList.get(v)){
                stack.push(neighbour);
            }
        }
        return false;
    }
}
