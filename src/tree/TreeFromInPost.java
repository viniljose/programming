package tree;

import java.util.HashMap;
import java.util.Map;

public class TreeFromInPost {
    Map<Integer,Integer> valueMap = new HashMap<>();
    int postEnd = 0;
    int[] inOrder;
    int[] postOrder;

    public static void main(String[] args) {
        int[] inOrder = new int[]{9,3,15,20,7};
        int[] postOrder = new int[]{9,15,7,20,3};
        TreeFromInPost tree = new TreeFromInPost();
        TreeNode result = tree.buildTree(inOrder,postOrder);
        TreeTraversal traversal = new TreeTraversal();
        System.out.println(traversal.levelOrder(result));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inOrder = inorder;
        this.postOrder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            valueMap.put(inorder[i],i);
        }
        postEnd = postorder.length-1;
        return helper(0,inorder.length-1);
    }

    private TreeNode helper(int start ,int end){
        if(start>end)
            return null;

        int root_val = postOrder[postEnd];
        TreeNode root = new TreeNode(root_val);
        int root_index = valueMap.get(root_val);
        postEnd--;
        root.right = helper(root_index+1,end);
        root.left = helper(start,root_index-1);
        return root;
    }

}
