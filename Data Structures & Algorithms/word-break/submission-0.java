class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i = 1; i <= len; i++){
            for(String word : wordDict){
                int id = i - word.length();
                if(id >= 0 && dp[id] && s.regionMatches(id, word, 0, word.length())){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
