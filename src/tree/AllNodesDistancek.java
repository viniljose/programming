package tree;

import java.util.*;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the
 * values of all nodes that have a distance k from the target node.
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Convert this to a graph and do a DFS
 */
public class AllNodesDistancek {
    Map<Integer,List<Integer>> graph;
    List<Integer> answer;
    Set<Integer> visited;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<>();
        //build the graph from tree
        buildGraph(root,null);
        answer = new ArrayList<>();
        visited = new HashSet<>();
        visited.add(target.val);
        dfs(target.val,0,k);
        return answer;
    }
    private void buildGraph(TreeNode curr, TreeNode parent){
        if(curr!=null && parent!=null){
            graph.computeIfAbsent(curr.val, a->new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val, a->new ArrayList<>()).add(curr.val);
        }
        if(curr.left!=null)
            buildGraph(curr.left,curr);
        if(curr.right!=null)
            buildGraph(curr.right,curr);
    }
    private void dfs(int curr,int distance,int k){
        if(distance==k){
            answer.add(curr);
            return;
        }
        for(int neigbor: graph.getOrDefault(curr,new ArrayList<>())){
            if(!visited.contains(neigbor)){
                visited.add(neigbor);
                dfs(neigbor,distance+1,k);
            }
        }
    }
}
