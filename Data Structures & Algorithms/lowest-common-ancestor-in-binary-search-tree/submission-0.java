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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null){
            return null;
        }
        if(root.val>p.val && root.val>q.val){
            root=root.left;
            return lowestCommonAncestor(root,p,q);
        }else if(root.val<p.val && root.val<q.val){
            root = root.right;
            return lowestCommonAncestor(root,p,q);
        }else if((root.val>p.val && root.val<q.val) || (root.val<p.val && root.val>q.val) || root.val==p.val || root.val==q.val){
            return root;
        }else{
            return null;
        }
    }
}
