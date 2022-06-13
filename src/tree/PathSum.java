package tree;

import java.util.Stack;
/**
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode tree =new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSum(tree,7));
        System.out.println(pathSum.hasPathSumIteration(tree,7));
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        targetSum = targetSum -root.val;
        if(root.left==null & root.right==null)
            return targetSum==0;
        return hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
    }

    public boolean hasPathSumIteration(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        Stack<TreeNode> stackTree = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();
        targetSum = targetSum - root.val;
        stackTree.push(root);
        stackSum.push(targetSum);
        while (!stackTree.isEmpty()){
            TreeNode node = stackTree.pop();
            Integer sum =stackSum.pop();
            if(node.left==null && node.right==null && sum==0)
                return true;
            if(node.left != null){
                stackTree.push(node.left);
                stackSum.push(sum-node.left.val);
            }
            if(node.right != null){
                stackTree.push(node.right);
                stackSum.push(sum-node.right.val);
            }
        }
       return false;
    }
}
