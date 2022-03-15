package tree;

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
}
