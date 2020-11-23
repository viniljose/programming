package tree;

import java.util.*;

public class BinaryTreeNode {
    public int val;
    public BinaryTreeNode left, right;
    public BinaryTreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
    public BinaryTreeNode(){

    }


    public void preOrder(BinaryTreeNode root){
        if(root != null){
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public List<Integer> preorderTraversal(BinaryTreeNode root) {
        List<Integer> lst = new ArrayList<Integer>();
        if(root ==null)
            return lst;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            BinaryTreeNode temp = stack.pop();
            lst.add(temp.val);
            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }

        return lst;

    }

    public void inOrder(BinaryTreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }

    public List<Integer> inorderTraversal(BinaryTreeNode root) {
        List<Integer> lst = new ArrayList<Integer>();
        if(root ==null)
            return lst;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode current = root;
        boolean done = false;
        while(!done){
           if(current != null) {
               stack.push(current);
               current = current.left;
           } else {
               if(stack.isEmpty())
                   done = true;
               else{
                   current = stack.pop();
                   lst.add(current.val);
                   current =current.right;
               }
           }
        }

        return lst;

    }

    public void postOrder(BinaryTreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }

    public List<Integer> postorderTraversal(BinaryTreeNode root) {
        List<Integer> lst = new ArrayList<Integer>();
        if(root ==null)
            return lst;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(root);
        BinaryTreeNode prev = null;
        while(!stack.isEmpty()){
            BinaryTreeNode curr = stack.peek();
            if(prev == null || prev.left== curr || prev.right == curr){
                if(curr.left != null)
                    stack.push(curr.left);
                else if (curr.right != null)
                    stack.push(curr.right);
            } else if (curr.left == prev ){
                if(curr.right != null)
                    stack.push(curr.right);
            } else {
                lst.add(curr.val);
                stack.pop();
            }
        prev = curr;
        }

        return lst;

    }
    public List<List<Integer>> levelOrder(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root ==null)
            return result;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        queue.offer(null);
        ArrayList<Integer> curr = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            BinaryTreeNode tmp = queue.poll();
            if(tmp !=null){
                curr.add(tmp.val);
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
            } else {
                ArrayList<Integer> curr_t = new ArrayList<Integer>(curr);
                result.add(curr_t);
                curr.clear();
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
            }
        }
    return result;
    }

    public int maxDepthRecursion(BinaryTreeNode root) {
        if(root == null)
            return 0;
        int leftLength = maxDepthRecursion(root.left);
        int rightLength = maxDepthRecursion(root.right);
        return leftLength > rightLength ? leftLength+1: rightLength +1;

    }

    public int minDepth(BinaryTreeNode root) {
        if(root == null)
            return 0;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        queue.offer(null);
        int count = 1;
        while(!queue.isEmpty()){
            BinaryTreeNode tmp = queue.poll();
            if(tmp != null) {
                if(tmp.left ==null & tmp.right ==null)
                    return count;
                if (tmp.left != null)
                    queue.offer(tmp.left);
                if (tmp.right != null)
                    queue.offer(tmp.right);
            } else {
                if(!queue.isEmpty())
                    count++;
                queue.offer(null);
            }
        }
        return count;
    }

    //TODO not correct
    public int diameterOfBinaryTree(BinaryTreeNode root) {
        if(root == null || (root.left==null && root.right==null))
            return 0;
        int left,right;
        left = diameterOfBinaryTree(root.left);
        right = diameterOfBinaryTree(root.right);

        return Math.max(left,right) +1;
    }

    public boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
        if (p == null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        if(p.val != q.val)
            return false;
        return  isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

    }

    

    public static void main(String[] args) {
        BinaryTreeNode tree =new BinaryTreeNode(1);
        tree.left = new BinaryTreeNode(2);
        tree.right = new BinaryTreeNode(3);
        tree.left.left = new BinaryTreeNode(4);
        tree.left.right = new BinaryTreeNode(5);
        tree.right.left = new BinaryTreeNode(6);
        tree.right.right = new BinaryTreeNode(7);

        //tree.preOrder(tree);
        //tree.inOrder(tree);
        //tree.postOrder(tree);
        List<List<Integer>> res = tree.levelOrder(tree);
        //System.out.println(res);
        //System.out.println(tree.maxDepthRecursion(tree));
        //System.out.println(tree.minDepth(tree));
        BinaryTreeNode tree1 =new BinaryTreeNode(1);
        tree1.left = null;
        tree1.right = new BinaryTreeNode(2);
        tree1.right.left = new BinaryTreeNode(3);
        List<Integer> lst = tree1.preorderTraversal(tree1);
        //System.out.println(lst);
        List<Integer> lst1 = tree1.inorderTraversal(tree1);
        //System.out.println(lst1);
        List<Integer> lst2 = tree1.postorderTraversal(tree1);
        //System.out.println(lst2);
        System.out.println(tree.minDepth(tree1));
    }
}
