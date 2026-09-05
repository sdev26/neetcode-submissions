class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        int maxProduct=nums[0];
        int minProduct=nums[0];
        int ans=nums[0];
        for(int i=1;i<n;i++){
           int prevMin=minProduct;
           int prevMax=maxProduct;
           maxProduct=Math.max(nums[i],Math.max(nums[i]*prevMax,nums[i]*prevMin));
           minProduct=Math.min(nums[i],Math.min(nums[i]*prevMax,nums[i]*prevMin));
           ans=Math.max(ans,maxProduct);
        }
        return ans;
    }
}
