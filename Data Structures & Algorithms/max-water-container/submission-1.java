class Solution {
    public int maxArea(int[] heights) {
        int left=0,right=heights.length-1;
        int max=0;
        while(left<right){
            int width=right-left;
            int minHeight=Math.min(heights[left],heights[right]);
            max=Math.max(max,width*minHeight);
            if(heights[left]<heights[right]){
                left++;
            }
            else
                right--;
        }
        return max;
    }
}
