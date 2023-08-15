package tree;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * https://leetcode.com/problems/diameter-of-binary-tree/editorial/
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * The longest path has to be between two leaf nodes.
 */
public class DiameterOfBinaryTree {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfsRecursion(root);
        return diameter;
    }
    private int dfsRecursion(TreeNode node){
        if(node==null)
        return 0;
        int left=dfsRecursion(node.left);
        int right = dfsRecursion(node.right);
        diameter = Math.max(diameter,left+right);
        return Math.max(left, right) +1;
    }
}

