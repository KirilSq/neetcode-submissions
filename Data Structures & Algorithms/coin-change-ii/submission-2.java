class Solution {
    public int change(int amount, int[] coins) {
        int coinCount = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int c = 0; c < coinCount; c++){
            int coin = coins[c];
            for(int i = coin; i <= amount; i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
