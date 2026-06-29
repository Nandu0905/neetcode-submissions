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

class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            // Swap left and right
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            // Visit left subtree
            if (current.left != null) {
                queue.offer(current.left);
            }
            // Visit right subtree
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return root;
    }
}