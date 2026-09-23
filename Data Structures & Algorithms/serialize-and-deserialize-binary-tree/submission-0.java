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
    public static final String DEL = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        sdfs(root, res);
        return res.toString();
    }

    private void sdfs(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append('N');
            res.append(DEL);
        } else {
            res.append(Integer.toString(root.val));
            res.append(DEL);
            sdfs(root.left, res);
            sdfs(root.right, res);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] i = {-1};
        return ddfs(data.split(DEL), i);
    }

    private TreeNode ddfs(String[] nodes, int[] i) {
        i[0]++;
        String sNode = nodes[i[0]];
        if (sNode.equals("N")) {
            return null;
        } else {
            TreeNode left = ddfs(nodes, i);
            TreeNode right = ddfs(nodes, i);
            TreeNode node = new TreeNode(Integer.parseInt(sNode), left, right);
            return node;
        }
    }
}
