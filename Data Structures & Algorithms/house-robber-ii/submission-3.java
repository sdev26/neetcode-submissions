class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1||n==2){
            if(n==1)
                return nums[0];
            if(n==2)
                return Math.max(nums[1],nums[0]);
        }
        return Math.max(robber(nums,0,n-1),robber(nums,1,n));
    }
    public int robber(int nums[],int start,int end){
        int prev2=nums[start];
        int prev1=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<end;i++){
            int temp=Math.max(prev1,nums[i]+prev2);
            prev2=prev1;
            prev1=temp;
        }
        return prev1;
    }
}
