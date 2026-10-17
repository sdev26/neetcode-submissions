class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        if(n==2)
            return Math.max(nums[0],nums[1]);
        return Math.max(find(nums,0,n-1),find(nums,1,n));
    }
    public int find(int[]nums,int start,int end){
        int prev2=nums[start];
        int prev1=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<end;i++){
            int curr=Math.max(prev1,nums[i]+prev2);
            prev2=prev1;
            prev1=curr;
        }
        return Math.max(prev1,prev2);
    }

}
