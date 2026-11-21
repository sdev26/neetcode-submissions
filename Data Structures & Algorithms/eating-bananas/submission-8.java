class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=0;
        for(int i:piles){
            right=Math.max(right,i);
        }
        while(left<right){
            int mid=left+(right-left)/2;
            int hours=0;
            for(int pile:piles){
                hours+=(pile+mid-1)/mid;
            }
                if(hours<=h)
                    right=mid;
                else
                    left=mid+1;
            
        }
        return left;
    }
}
