package tree;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 *  A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 */
public class MaximumPathSum {
    int max_value = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max_value;
    }

    private int maxGain(TreeNode node) {
        if(node==null)
        return 0;
        int leftGain = Math.max(maxGain(node.left),0);
        int rightGain = Math.max(maxGain(node.right), 0);
        int currentSum = node.val+leftGain+rightGain;
        max_value = Math.max(max_value, currentSum);
        return node.val+Math.max(leftGain, rightGain);

    }
}
