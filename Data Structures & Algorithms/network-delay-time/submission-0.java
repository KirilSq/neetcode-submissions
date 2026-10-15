class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            adjList.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }
        int[] dist = new int[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.add(new int[] {k, 0});
        int visitedCount = 0;
        int maxDistance = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];
            if (d > dist[u]) {
                continue;
            }
            visitedCount++;
            maxDistance = Math.max(maxDistance, d);
            for (int[] edge : adjList.get(u)) {
                int v = edge[0];
                int weight = edge[1];
                if (d + weight < dist[v]) {
                    dist[v] = d + weight;
                    pq.add(new int[] {v, dist[v]});
                }
            }
        }
        return visitedCount == n ? maxDistance : -1;
    }
}
