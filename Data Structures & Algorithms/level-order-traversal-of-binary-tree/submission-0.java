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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, list, 0);
        return list;
    }

    private void levelOrder(TreeNode curr, List<List<Integer>> list, int level){
        if(curr != null){
            if(list.size() <= level){
                list.add(new ArrayList<>());
            }
            list.get(level).add(curr.val);
            levelOrder(curr.left, list, level + 1);
            levelOrder(curr.right, list, level + 1);
        }
    }
}
