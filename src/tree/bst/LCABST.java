package tree.bst;

import tree.TreeNode;
/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LCABST {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pValue = p.val;
        int qValue = q.val;

        TreeNode curr = root;
        while (curr != null){
            int nodeValue = curr.val;
            if(pValue>nodeValue && qValue > nodeValue){
                curr = curr.right;
            } else if(pValue<nodeValue && qValue <nodeValue){
                curr = curr.left;
            } else {
                return curr;
            }
        }
        return null;
    }
}
