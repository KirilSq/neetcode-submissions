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
    public boolean isBalanced(TreeNode root) {
        boolean[] result = {true};
        dfs(root, result);
        return result[0];
    }
    public int dfs(TreeNode root, boolean[] result){
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left, result);
        int right = dfs(root.right, result);
        result[0] = Math.abs(left - right) <= 1 ? result[0] : false;
        return 1 + Math.max(left, right);
    }
}
