class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int size1 = s1.length();
        int size2 = s2.length();
        int size3 = s3.length();
        if(size1 + size2 != size3){
            return false;
        }
        boolean[][] dp = new boolean[size1+1][size2+1];
        dp[0][0] = true;
        for(int i=0; i<size1 && s1.charAt(i) == s3.charAt(i); i++){
            dp[i+1][0] = true;
        }
        for(int i=0; i<size2 && s2.charAt(i) == s3.charAt(i); i++){
            dp[0][i+1] = true;
        }

        //dp[x][y] = dp[x-1][y] && s1.charAt(x-1) == s3.charAt(x + y - 1)
        // || dp[x][y-1] && s2.charAt(y-1) == s3.charAt(x + y - 1)
        for(int i=1; i<=size1; i++){
            char s1Ch = s1.charAt(i-1);
            for(int j=1; j<=size2; j++){
                char s3Ch = s3.charAt(i+j-1);
                dp[i][j] = dp[i-1][j] && s1Ch == s3Ch
                || dp[i][j-1] && s2.charAt(j-1) == s3Ch;
            }
        }
        return dp[size1][size2];
    }
}
