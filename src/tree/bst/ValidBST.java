package tree.bst;

import tree.TreeNode;

public class ValidBST {
    public static void main(String[] args) {
        TreeNode tree =new TreeNode(10);
        tree.left = new TreeNode(5);
        tree.right = new TreeNode(15);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(7);
        tree.right.right = new TreeNode(17);

        ValidBST validBST = new ValidBST();
        System.out.println(validBST.isValidBST(tree));
    }

    //Using Recursion
    //Time and Space o(n) & o(n)
    public boolean isValidBST(TreeNode root) {
        return validate(root,null, null);
    }

    private boolean validate(TreeNode node,Integer low,Integer high){
        if(node == null)
            return true;
        if((low != null && (node.val <= low)) || (high!=null && (node.val>=high))){
            return false;
        }
        return validate(node.left,low,node.val) && validate(node.right,node.val,high);
    }
}
