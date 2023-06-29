package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can
 * be serialized to a string and this string can be deserialized to the original tree structure.
 */
public class Serialize {
    public static void main(String[] args) {
        TreeNode tree =new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);

        Serialize serialize = new Serialize();
        System.out.println(serialize.serialize(tree));
        TreeNode node = serialize.deserialize(serialize.serialize(tree));
        TreeTraversal traversal = new TreeTraversal();
        System.out.println(traversal.levelOrder(node));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return helper(root,"");
    }
    private String helper(TreeNode node,String content){
        if(node == null)
            content+="null,";
        else {
            content += node.val+",";
            content = helper(node.left,content);
            content = helper(node.right,content);
        }
        return content;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(values));
        return decodeHelper(dataList);
    }

    private TreeNode decodeHelper( List<String> values){
        if (values.get(0).equals("null")){
            values.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(values.get(0)));
        values.remove(0);
        node.left = decodeHelper(values);
        node.right = decodeHelper(values);
        return node;
    }
}
