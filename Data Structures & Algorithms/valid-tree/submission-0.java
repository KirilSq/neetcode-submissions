class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        int visitedCount = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int neighbor : adjList.get(cur)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.add(neighbor);
                    visitedCount++;
                }
            }
        }
        return visitedCount == n;
    }
}
