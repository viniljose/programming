package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class Zigzag {
    public static void main(String[] args) {
        Zigzag zigzag = new Zigzag();
        TreeNode tree4=new TreeNode(1);
        tree4.left = new TreeNode(2);
        tree4.right = new TreeNode(3);
        tree4.left.left = new TreeNode(4);
        tree4.right.right = new TreeNode(5);
        System.out.println(zigzag.zigzagLevelOrder(tree4));
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList levelList = new LinkedList();
        boolean isleftOrder = true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr != null){

                if(isleftOrder) {
                    levelList.addLast(curr.val);
                } else {
                    levelList.addFirst(curr.val);
                }
                if(curr.left !=null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            } else {
                result.add(levelList);
                levelList = new LinkedList();
                isleftOrder = !isleftOrder;
                if(!queue.isEmpty())
                    queue.add(null);
            }
        }
        return result;
    }
}
