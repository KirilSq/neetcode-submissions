class Solution {
    public int change(int amount, int[] coins) {
        int coinCount = coins.length;
        int[][] dp = new int[coinCount][amount+1];
        for(int i = 0; i <= amount; i+=coins[0]){
            dp[0][i] = 1;
        }

        for(int c = 1; c < coinCount; c++){
            int coin = coins[c];
            for(int i = 0; i < coin && i <= amount; i++){
                dp[c][i] = dp[c-1][i];
            }
            for(int i = coin; i <= amount; i++){
                dp[c][i] = dp[c-1][i] + dp[c][i-coin];
            }
        }
        return dp[coinCount-1][amount];
    }
}
