package tree;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
