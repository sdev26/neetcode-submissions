class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=0;
        for(int i:piles){
            high=Math.max(i,high);
        }
        while(low<high){
            int mid=low+(high-low)/2;
            int hours=0;
            for(int i:piles){
                hours+=(i+mid-1)/mid;
            }
            if(hours<=h)
                high=mid;
            else
                low=mid+1;
        }
        return low;
    }
}
