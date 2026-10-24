class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] costToReach = new int[n + 1];
        costToReach[0] = 0;
        costToReach[1] = 0;
        for (int i = 2; i <= n; i++) {
        costToReach[i] = Math.min(costToReach[i-1] + cost[i-1],
        costToReach[i-2] + cost[i-2]);
        }
        return costToReach[n];
    }
}
