class Solution {
    public boolean canPartition(int[] nums) {
        int rSum=0;
        for(int i:nums){
            rSum+=i;
        }
        if(rSum%2!=0){
            return false;
        }
        rSum=rSum/2;
        return sum(nums,rSum);
    }
    public boolean sum(int nums[],int sum){
        int n=nums.length;
        boolean[][]dp=new boolean[nums.length+1][sum+1];
        for(int i=0;i<=nums.length;i++){
            dp[i][0]=true;
        }
        for(int i=0;i<=sum;i++){
            dp[0][i]=false;
        }
    dp[0][0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j]=dp[i-1][j];
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
