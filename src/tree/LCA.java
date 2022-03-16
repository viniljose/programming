package tree;

import java.util.*;

public class LCA {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode,TreeNode> parentsMap = new HashMap<>();

        stack.push(root);
        parentsMap.put(root,null);

        while (!parentsMap.containsKey(p) || !parentsMap.containsKey(q)){
            TreeNode curr = stack.pop();
            if(curr.left != null){
                stack.push(curr.left);
                parentsMap.put(curr.left,curr);
            }
            if(curr.right != null){
                stack.push(curr.right);
                parentsMap.put(curr.right,curr);
            }
        }
        Set<TreeNode> parentsList = new HashSet<>();
        while (p!=null){
            parentsList.add(p);
            p = parentsMap.get(p);
        }
        while (!parentsList.contains(q)){
            q= parentsMap.get(q);
        }
        return q;
    }
}
