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
        depth.maximumDepth(tree,1);
        System.out.println(depth.answer);
        System.out.println(depth.maximumDepthBottomUp(tree));
    }

    private void maximumDepth(TreeNode root, int depth) {
        if(root == null)
            return;
        if(root.left == null && root.right==null){
            answer = Math.max(answer,depth);
        }
        maximumDepth(root.left,depth+1);
        maximumDepth(root.right,depth+1);
    }

    private int maximumDepthBottomUp(TreeNode root){
        if(root == null)
            return 0;
        int left = maximumDepthBottomUp(root.left);
        int right = maximumDepthBottomUp(root.right);
        return Math.max(left,right)+1;
    }
}
