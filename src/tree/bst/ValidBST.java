package tree.bst;

import tree.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 */
public class ValidBST {
    private Stack<TreeNode> stack = new Stack<>();
    private Stack<Integer> upperLimit = new Stack<>();
    private Stack<Integer> lowerLimit = new Stack<>();

    public static void main(String[] args) {
        TreeNode tree =new TreeNode(10);
        tree.left = new TreeNode(5);
        tree.right = new TreeNode(15);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(7);
        tree.right.right = new TreeNode(17);

        ValidBST validBST = new ValidBST();
        System.out.println(validBST.isValidBST(tree));
        System.out.println(validBST.isValidBSTIterative(tree));
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

    private void add(TreeNode node,Integer low,Integer high){
        stack.add(node);
        lowerLimit.add(low);
        upperLimit.add(high);
    }


    public boolean isValidBSTIterative(TreeNode root) {
        Integer low = null;
        Integer high = null;
        Integer val = null;
        add(root,low,high);
        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            low = lowerLimit.pop();
            high = upperLimit.pop();
            if(curr == null) continue;
            val = curr.val;
            if(low != null && val <= low)
                return false;
            if(high != null && val >= high)
                return false;
            add(curr.right,val,high);
            add(curr.left,low,val);
        }
        return true;
    }
}
