class Solution {
    public int maxProduct(int[] nums) {
        int minProd=1;
        int maxProd=1;
        int ans=nums[0];
        for(int i=0;i<nums.length;i++){
            int tempmin=Math.min(nums[i],Math.min(nums[i]*minProd,nums[i]*maxProd));
            int tempmax=Math.max(nums[i],Math.max(nums[i]*minProd,nums[i]*maxProd));
            minProd=tempmin;
            maxProd=tempmax;
            ans=Math.max(ans,maxProd);
        }
        return ans;
    }
}
