package tree.bst;

import tree.TreeNode;

public class IsBalancedTree {

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return (Math.abs(height(root.left)-height(root.right))<2) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node){
        if(node == null)
            return -1;
        return 1+ Math.max(height(node.left),height(node.right));
    }
}
