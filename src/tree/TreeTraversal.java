package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {
    public static void main(String[] args) {
        TreeTraversal traversal = new TreeTraversal();

        //pre-order data
        TreeNode tree =new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        System.out.println(traversal.preorderTraversal(tree));

        //in-order data
        TreeNode tree2 =new TreeNode(4);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(5);
        tree2.left.left = new TreeNode(1);
        tree2.left.right = new TreeNode(3);
        System.out.println(traversal.inorderTraversal(tree2));
        System.out.println(traversal.inorderIteration(tree2));

        //post-order data
        TreeNode tree3=new TreeNode(5);
        tree3.left = new TreeNode(3);
        tree3.right = new TreeNode(4);
        tree3.left.left = new TreeNode(1);
        tree3.left.right = new TreeNode(2);

        //BFS data
        TreeNode tree4=new TreeNode(1);
        tree4.left = new TreeNode(2);
        tree4.right = new TreeNode(3);
        tree4.left.left = new TreeNode(4);
        tree4.left.right = new TreeNode(5);

    }
    //iteration
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root==null)
            return results;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            results.add(node.val);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return results;
    }

    //recursion
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        inorderHelper(root,results);
        return results;
    }
    private void inorderHelper(TreeNode root, List<Integer> results){
        if(root != null) {
            inorderHelper(root.left, results);
            results.add(root.val);
            inorderHelper(root.right, results);
        }
    }

    //Iteration
    public List<Integer> inorderIteration(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr!= null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            results.add(curr.val);
            curr=curr.right;
        }
        return results;
    }


}
