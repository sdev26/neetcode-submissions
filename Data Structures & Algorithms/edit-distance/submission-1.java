class Solution {
    public int minDistance(String word1, String word2) {
        int s1=word1.length();
        int s2=word2.length();
        int dp[][]=new int[s1+1][s2+1];
        for(int i=0;i<=s1;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=s2;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=s1;i++){
            for(int j=1;j<=s2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
            }
        }
        return dp[s1][s2];
    }
}
