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
        return dfs(root, Integer.MIN_VALUE);
    }
    private int dfs(TreeNode root, int max){
        if(root == null){
            return 0;
        }else if(root.val >= max){
            return 1 + dfs(root.left, root.val) + dfs(root.right, root.val);
        }else return dfs(root.left, max) + dfs(root.right, max);
    }
}
