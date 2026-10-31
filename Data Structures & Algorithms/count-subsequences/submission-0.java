class Solution {
    char[] s;
    char[] t;
    int sLen;
    int tLen;
    int[][] dp;

    public int numDistinct(String s, String t) {
        sLen = s.length();
        tLen = t.length();
        dp = new int[tLen][sLen];
        this.s = s.toCharArray();
        this.t = t.toCharArray();
        for(int i = 0; i < tLen; i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0);
    }
    
    private int dfs(int sId, int tId){
        if(tId >= tLen){
            return 1;
        }
        if(sId >= sLen){
            return 0;
        }
        if(dp[tId][sId] == -1){
            dp[tId][sId] = dfs(sId+1, tId) 
        + (s[sId] == t[tId] ? dfs(sId+1, tId +1) : 0);
        }
        return dp[tId][sId];
    }
}
