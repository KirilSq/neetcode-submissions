class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() > s2.length()){
            return isInterleave(s2, s1, s3);
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        if(c1.length + c2.length != c3.length){
            return false;
        }
        boolean[] dp = new boolean[c1.length+1];
        dp[0] = true;
        for(int i = 0; i < c1.length && c1[i] == c3[i]; i++){
            dp[i+1]= true;
        }
        boolean hasAdvanced = true;
        for(int i = 0; i < c2.length && hasAdvanced; i++){
            dp[0] = dp[0] && c2[i] == c3[i];
            hasAdvanced = dp[0];
            for(int j = 1; j <= c1.length; j++){
                dp[j] = dp[j-1] && c1[j-1] == c3[i+j]
                || dp[j] && c2[i] == c3[i+j];
                hasAdvanced |= dp[j];
            }
        }
        return hasAdvanced && dp[c1.length];
    }
}
