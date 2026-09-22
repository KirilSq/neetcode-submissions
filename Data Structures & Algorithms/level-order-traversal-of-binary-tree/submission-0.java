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
    private record Pair(TreeNode node, int depth){}
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        int depth = -1;
        
        Queue<Pair> bfs = new ArrayDeque<>();
        bfs.offer(new Pair(root, 0));
        while(!bfs.isEmpty()){
            Pair curr = bfs.poll();
            if(depth != curr.depth()){
                depth = curr.depth();
                result.add(new LinkedList<>());
            }
            result.getLast().addLast(curr.node().val);
            if(curr.node().left != null){
                bfs.offer(new Pair(curr.node().left, depth + 1));
            }
            if(curr.node().right != null){
                bfs.offer(new Pair(curr.node().right, depth + 1));
            }
        }
        return result;
    }
}
