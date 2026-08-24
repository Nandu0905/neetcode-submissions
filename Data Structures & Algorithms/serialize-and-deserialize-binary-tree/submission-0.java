/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    StringBuilder sb = new StringBuilder();
    public String serialize(TreeNode root) {
        serializeMethod(root);
        return sb.toString();
    }
    private void serializeMethod(TreeNode root){
        if(root==null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serializeMethod(root.left);
        serializeMethod(root.right);
    }

    // Decodes your encoded data to tree.
    int index=0;
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        return deserializeMethod(array);
    }
    private TreeNode deserializeMethod(String[] array){
        if(array[index].equals("null")){
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(array[index]));
        index++;
        node.left = deserializeMethod(array);
        node.right=deserializeMethod(array);
        return node;
    }
}
