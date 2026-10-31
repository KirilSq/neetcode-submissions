class Solution {
    public int numDistinct(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int[][] dp = new int[sarr.length][tarr.length]; //dp[prefix:i][prefix:j] = dp[i-1][j
        dp[0][0] = sarr[0] == tarr[0] ? 1 : 0;
        for(int i = 1; i < sarr.length; i++){
            char sc = sarr[i];
            dp[i][0] = dp[i-1][0] + (sc == tarr[0] ? 1 : 0);
            for(int j =1; j < tarr.length; j++){
                dp[i][j] = dp[i-1][j] + (sc == tarr[j] ? dp[i-1][j-1] : 0);
            }
        }
        return dp[sarr.length-1][tarr.length-1];
    }
}
