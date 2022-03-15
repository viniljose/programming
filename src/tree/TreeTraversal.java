package tree;

import java.util.*;

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
        System.out.println(traversal.postorderTraversal(tree3));

        //BFS data
        TreeNode tree4=new TreeNode(1);
        tree4.left = new TreeNode(2);
        tree4.right = new TreeNode(3);
        tree4.left.left = new TreeNode(4);
        tree4.left.right = new TreeNode(5);
        System.out.println(traversal.levelOrder(tree4));

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

    //recursion
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        postoderHelper(root,results);
        return results;
    }
    private void postoderHelper(TreeNode root, List<Integer> results){
        if(root != null){
            postoderHelper(root.left,results);
            postoderHelper(root.right,results);
            results.add(root.val);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        queue.offer(null);
        List levelList = new ArrayList();
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr!= null){
                levelList.add(curr.val);
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            } else {
                List curr_list = new ArrayList(levelList);
                result.add(curr_list);
                levelList.clear();
                if(!queue.isEmpty())
                 queue.offer(null);
            }
        }
        return result;
    }
}
