class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() < word2.length()){
            return minDistance(word2, word1);
        }
        if(word2.length() == 0){
            return word1.length();
        }
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] dp = new int[w1.length][w2.length];
        if(w1[0] != w2[0]){
            dp[0][0] = 1;
        }
        for(int j = 1; j < w2.length; j++){
            dp[0][j] = w1[0] == w2[j] ? j : (1 + dp[0][j-1]);
        }
        for(int i=1; i<w1.length; i++){
            char c1 = w1[i];
            if(c1 == w2[0]){
                dp[i][0] = i;
            }else {
                dp[i][0] = 1 + dp[i-1][0];
            }
            for(int j=1; j<w2.length; j++){
                if(c1 == w2[j]){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1],
                     Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }
        return dp[w1.length-1][w2.length-1];
    }
}
