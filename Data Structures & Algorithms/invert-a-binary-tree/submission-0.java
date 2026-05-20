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
        if(root == null){
            return null;
        }
        return invert(root);
    }

    private TreeNode invert(TreeNode curr){
        if(curr.left == null && curr.right == null){
            return curr;
        }
        // if(curr.left == null){
            
        // }
        TreeNode left = curr.left;
        curr.left = curr.right;
        curr.right = left;
        invertTree(curr.left);
        invertTree(curr.right);
        return curr;
    }
}
