class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>dq=new LinkedList<>();
        int n=nums.length,index=0;int res[]=new int[n-k+1];
        for(int right=0;right<n;right++){
            while(!dq.isEmpty()&&dq.peekFirst()<=right-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty()&&nums[dq.peekLast()]<=nums[right]){
                dq.pollLast();
            }
            dq.offerLast(right);
            if(right>=k-1){
                res[index++]=nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
