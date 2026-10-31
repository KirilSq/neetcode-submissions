class Solution {
    public int numDistinct(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int[] dp = new int[tarr.length]; 
        dp[0] = sarr[0] == tarr[0] ? 1 : 0;
        for(int i = 1; i < sarr.length; i++){
            char sc = sarr[i];
            for(int j = tarr.length - 1; j >= 1 ; j--){
                dp[j] += sc == tarr[j] ? dp[j-1] : 0;
            }
            dp[0] += (sc == tarr[0] ? 1 : 0);
        }
        return dp[tarr.length-1];
    }
}
