/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        HashMap<Node, Node> cloned = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        cloned.put(node, new Node(node.val));
        while(!q.isEmpty()){
            Node cur = q.poll();
            Node copy = cloned.get(cur);
            for(Node neighbor : cur.neighbors){
                Node nCopy = cloned.get(neighbor);
                if(nCopy == null){
                    nCopy = new Node(neighbor.val);
                    q.offer(neighbor);
                    cloned.put(neighbor, nCopy);
                }
                copy.neighbors.add(nCopy);
            }
        }
        return cloned.get(node); 
    }
}