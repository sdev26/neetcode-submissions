class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(Math.abs(target)>sum||(sum+target)%2!=0)
            return 0;
        sum=(sum+target)/2;
        int dp[]=new int[sum+1];
        dp[0]=1;
        for(int i=0;i<nums.length;i++){
            for(int j=sum;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[sum];
    }
}
