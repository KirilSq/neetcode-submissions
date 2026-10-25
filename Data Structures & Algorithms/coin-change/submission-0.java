class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int cnt = coins.length;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < cnt; j++){
                int remainder = i - coins[j];
                if(remainder >= 0 && dp[remainder] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[remainder] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
