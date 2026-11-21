class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=0;
        for(int i:piles){
            right=Math.max(i,right);
        }
        while(left<right){
            int hours=0;int mid=left+(right-left)/2;
            for(int i:piles){
                hours+=(i+(double)mid-1)/mid;
            }
                if(hours<=h)
                    right=mid;
                else
                    left=mid+1;
            }
        
        return left;
    }
}
