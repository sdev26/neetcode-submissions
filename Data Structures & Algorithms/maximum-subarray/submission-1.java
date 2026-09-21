class Solution {

    public int maxSubArray(int[] nums) {
        int currSum=0;
        int n=nums.length;
        if(n==1)
            return nums[0];
        int ans=Integer.MIN_VALUE;
        int arr[]=new int[n];
        for(int i=0;i<nums.length;i++){
            currSum = Math.max(currSum + nums[i], nums[i]);
            ans=Math.max(ans,currSum);
        }        
        return ans;
    }
}
