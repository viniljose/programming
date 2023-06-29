package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/symmetric-tree/
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class Symmetric {
    public static void main(String[] args) {
        TreeNode tree =new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(3);
        Symmetric symmetric = new Symmetric();
        System.out.println(symmetric.isSymmetricRecursion(tree));
        System.out.println(symmetric.isSymmetric(tree));
    }

    public boolean isSymmetricRecursion(TreeNode root) {
        return isMirror(root,root);
    }

    private boolean isMirror(TreeNode root1,TreeNode root2){
        if(root1==null & root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        return (root1.val==root2.val)
                && isMirror(root1.left,root2.right)
                && isMirror(root1.right,root2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1==null && node2==null) continue;
            if(node1==null || node2==null) return false;
            if(node1.val != node2.val) return false;
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }
}
