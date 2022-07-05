package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
 * find all possible paths from node 0 to node n - 1 and return them in any order.
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Time Complexity: O(2^V.V)
 * Space Complexity: O(V)
 */
public class AllPaths {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if(graph==null || graph.length==0)
            return  paths;
        dfs(graph,0,new ArrayList<>(),paths);
        return paths;
    }
    public void dfs(int[][] graph,int v,List<Integer> path,List<List<Integer>> paths){
        path.add(v);
        if(v==graph.length-1){
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] neighbours = graph[v];
        for(int w : neighbours){
            dfs(graph,w,path,paths);
            path.remove(path.size()-1);
        }
    }
}
