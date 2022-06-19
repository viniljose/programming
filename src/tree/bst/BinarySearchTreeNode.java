package tree.bst;
/**
 * A Binary Search Tree is a special form of a binary tree.
 * The value in each node must be greater than (or equal to) any values in its left subtree but less than (or equal to)
 * any values in its right subtree
 */
public class BinarySearchTreeNode {
    int val;
    BinarySearchTreeNode left;
    BinarySearchTreeNode right;
    BinarySearchTreeNode() {}
    BinarySearchTreeNode(int val) { this.val = val; }
    BinarySearchTreeNode(int val, BinarySearchTreeNode left, BinarySearchTreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    public static void main(String[] args) {
        BinarySearchTreeNode bst = new BinarySearchTreeNode(7);
        bst.left = new BinarySearchTreeNode(4);
        bst.right = new BinarySearchTreeNode(9);
        bst.left.left = new BinarySearchTreeNode(2);
        bst.left.right = new BinarySearchTreeNode(5);

        System.out.println(bst.findRecursive(bst,2).val);
    }

    public BinarySearchTreeNode findRecursive(BinarySearchTreeNode root,int data){
        if(root == null)
            return root;
        if( data > root.val)
            return findRecursive(root.right,data);
        else if(data < root.val)
            return findRecursive(root.left,data);
        return root;

    }
}
