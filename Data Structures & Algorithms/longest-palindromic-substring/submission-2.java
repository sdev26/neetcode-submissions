class Solution {
    public String longestPalindrome(String s) {
       int n=s.length();
       boolean dp[][]=new boolean[n][n];
       for(int i=0;i<n;i++){
        dp[i][i]=true;
       }
       int maxLength=1,start=0;
       for(int i=n-1;i>=0;i--){
        for(int j=i+1;j<n;j++){
            if(s.charAt(i)==s.charAt(j)){
                if(j-i<=2){
                    dp[i][j]=true;
                }
                else
                    dp[i][j]=dp[i+1][j-1];
            }
        
        if(dp[i][j]&&j-i+1>maxLength){
            maxLength=j-i+1;
            start=i;
        }
        }
       }
       return s.substring(start,start+maxLength);
    }
}
