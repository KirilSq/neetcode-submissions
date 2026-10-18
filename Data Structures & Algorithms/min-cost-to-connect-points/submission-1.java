class Solution {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        int[] dist = new int[len];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[len];
        dist[0] = 0;
        int edges = 0, res = 0, node = 0;
        while (edges < len - 1) {
            visited[node] = true;
            int nextNode = -1;
            for (int j = 0; j < len; j++) {
                if (visited[j]) {
                    continue;
                }
                dist[j] = Math.min(dist[j], getDist(points[node], points[j]));
                if (nextNode == -1 || dist[j] < dist[nextNode]) {
                    nextNode = j;
                }
            }
            res += dist[nextNode];
            node = nextNode;
            edges++;
        }
        return res;
    }

    private int getDist(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
