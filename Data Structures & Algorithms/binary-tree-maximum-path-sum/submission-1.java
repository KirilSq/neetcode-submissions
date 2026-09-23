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
    public int maxPathSum(TreeNode root) {
        int[] result = {Integer.MIN_VALUE};
        dfs(root, result);
        return result[0];
        
    }
    public int dfs(TreeNode root, int[] max){
        if(root == null) {
            return 0;
        }
        int leftGain = Math.max(dfs(root.left, max), 0);
        int rightGain = Math.max(dfs(root.right, max), 0);
        max[0] = Math.max(root.val + leftGain + rightGain, max[0]);
        return Math.max(root.val + leftGain, root.val + rightGain);
    }
}
