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
    public int goodNodes(TreeNode root) {
        return currentMax(root,root.val);
    }
    private int currentMax(TreeNode root,int maxValue){
        if(root==null){
            return 0;
        }
        int count =0;
        if(root.val>=maxValue){
            count=1;
        }
        maxValue = Math.max(maxValue,root.val);
        count= count+currentMax(root.left,maxValue);
        count = count+currentMax(root.right,maxValue);
        return count;
    }
}
