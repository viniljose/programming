package tree;

public class Depth {
    private int answer = 0;
    public static void main(String[] args) {
        TreeNode tree =new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        Depth depth = new Depth();
        depth.maximum_depth(tree,1);
        System.out.println(depth.answer);

    }

    private void maximum_depth(TreeNode root, int depth) {
        if(root == null)
            return;
        if(root.left == null && root.right==null){
            answer = Math.max(answer,depth);
        }
        maximum_depth(root.left,depth+1);
        maximum_depth(root.right,depth+1);
    }
}
