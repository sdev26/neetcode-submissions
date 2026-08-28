class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum<Math.abs(target))
            return 0; 
        if((sum+target)%2!=0)
            return 0;
        sum=(sum+target)/2;
        int dp[]=new int [sum+1];
        dp[0]=1;
        for(int i:nums){
            for(int j=sum;j>=i;j--){
                dp[j]+=dp[j-i];
            }
        }
       return dp[sum];
    }
}
