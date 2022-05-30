package tree;

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

