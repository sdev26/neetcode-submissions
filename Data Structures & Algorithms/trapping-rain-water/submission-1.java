class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0,right=n-1;
        int maxLeft=0,maxRight=0,water=0;
        while(left<right){
            if(height[left]<height[right]){
                maxLeft=Math.max(maxLeft,height[left]);
                water+=maxLeft-height[left];
                left++;
            }
            else{
                maxRight=Math.max(maxRight,height[right]);
                water+=maxRight-height[right];
                right--;
            }
        }
        return water;
    }
}
