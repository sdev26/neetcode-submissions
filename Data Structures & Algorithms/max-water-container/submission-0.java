class Solution {
    public int maxArea(int[] heights) {
        int left=0,right=heights.length-1;
        int max=0;
        while(left<right){
            int minHeight=Math.min(heights[left],heights[right]);
            int width=right-left;
            max=Math.max(max,minHeight*width);
            if(heights[left]<heights[right]){
                left++;
            }
            else
                right--;
        }
        return max;
    }
}
