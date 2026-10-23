class Solution {
    public int climbStairs(int n) {
        int prev_prev = 1;
        int prev = 1;
        for(int i = 2; i <= n; i++){
            int bucket = prev;
            prev+=prev_prev;
            prev_prev = bucket;
        }
        return prev;
    }
}
