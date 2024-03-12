package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/clone-graph/description/
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 */
public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    private HashMap<Node,Node> visited = new HashMap<>();

    /**
     * We are doing DFS with recursion and a HashMap
     * Time Complexity: O(N+M), where N is a number of nodes (vertices) and M is a number of edges.
     * Space Complexity: O(N). This space is occupied by the visited hash map and in addition to that,
     * space would also be occupied by the recursion stack since we are adopting a recursive approach here.
     * The space occupied by the recursion stack would be equal to O(H) where HH is the height of the graph.
     * Overall, the space complexity would be O(N).
     */

    public Node cloneGraph(Node node) {
        if(node == null)
            return node;

        if(visited.containsKey(node))
            return visited.get(node);

        Node clone = new Node(node.val,new ArrayList<>());
        visited.put(node,clone);

        for(Node n : node.neighbors)
            clone.neighbors.add(cloneGraph(n));
        return clone;
    }
}
