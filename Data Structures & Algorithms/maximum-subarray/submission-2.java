class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int ans=nums[0];
        int currSum=nums[0];
        for(int i=1;i<nums.length;i++){
            currSum=Math.max(nums[i]+currSum,nums[i]);
            ans=Math.max(ans,currSum);
        }
        return ans;
    }
}
