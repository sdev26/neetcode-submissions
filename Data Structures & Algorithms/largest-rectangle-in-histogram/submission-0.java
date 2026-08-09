class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>st=new Stack<>();
        int maxHeight=0;
        int n=heights.length;
        for(int i=0;i<=n;i++){
            int currHeight=(i==n)?0:heights[i];
            while(!st.isEmpty()&&currHeight<heights[st.peek()]){
                int height=heights[st.pop()];
                int left=(st.size()==0)?-1:st.peek();
                int right= i;
                int width=right-left-1;
                maxHeight=Math.max(maxHeight,width*height);         
            }
            st.push(i);
        }
        return maxHeight;
    }
}
