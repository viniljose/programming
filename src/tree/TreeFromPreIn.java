package tree;

import java.util.HashMap;
import java.util.Map;

public class TreeFromPreIn {
    int[] preOrder;
    int preStart=0;
    Map<Integer,Integer> indexValues = new HashMap<>();
    public static void main(String[] args) {
        int[] inOrder = new int[]{9,3,15,20,7};
        int[] preOrder = new int[]{3,9,20,15,7};
        TreeFromPreIn tree = new TreeFromPreIn();
        TreeNode result = tree.buildTree(preOrder,inOrder);
        TreeTraversal traversal = new TreeTraversal();
        System.out.println(traversal.levelOrder(result));
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder=preorder;
        for (int i = 0; i < inorder.length; i++) {
            indexValues.put(inorder[i],i);
        }
        return helper(0,preorder.length-1);
    }

    private TreeNode helper(int start,int end){
        if(start>end)
            return null;
        int root_value = preOrder[preStart];
        TreeNode root = new TreeNode(root_value);
        preStart++;
        int root_index = indexValues.get(root_value);
        root.left = helper(start,root_index-1);
        root.right = helper(root_index+1,end);
        return root;
    }
}
