class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] flight : flights){
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        int[] minPrice = new int[n];
        Arrays.fill(minPrice, Integer.MAX_VALUE);
        minPrice[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        int cnt = 0;
        while(!q.isEmpty() && cnt <= k){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int u = cur[0], price = cur[1];
                for(int[] edge : adj[u]){
                    int v = edge[0], w = edge[1];
                    if(price + w < minPrice[v]){
                        minPrice[v] = price + w;
                        q.offer(new int[]{v, price + w});
                    }
                }
            }
            cnt++;
        }
        return minPrice[dst] == Integer.MAX_VALUE ? -1 : minPrice[dst];
    }
}
