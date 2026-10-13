class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n){
        parent = new int[n];
        Arrays.setAll(parent, i -> i);
        rank = new int[n];
        Arrays.fill(rank, 1);
    }

    public int find(int el) {
        int cur = el;
        while (cur != parent[cur]){
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }
        return cur;
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv){
            return false;
        }
        if (rank[pu] < rank[pv]){
            int bucket = pu;
            pu = pv;
            pv = bucket;
        }
        parent[pv] = pu;
        rank[pu] += rank[pv];
        return true;
    }

}


class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges){
            if(uf.union(edge[0], edge[1])){
                n--;
            }
        }
        return n;       
    }
}
