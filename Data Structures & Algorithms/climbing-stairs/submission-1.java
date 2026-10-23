class Solution {
    public int climbStairs(int n) {
        int[] results = new int[n+1];
        results[0] = 1;
        results[1] = 1;
        for(int i = 2; i <= n; i++){
            results[i] = results[i - 2] + results[i-1];
        }
        return results[n];
    }
}
