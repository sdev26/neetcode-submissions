class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPiles=0;
        for(int i:piles){
            maxPiles=Math.max(maxPiles,i);
        }
        int left=1,right=maxPiles;
        int ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(isPossible(mid,piles,h)){
                ans=mid;
                right=mid-1;
            }
            else
                left=mid+1;
        }
        return ans;
    }
    public boolean isPossible(int mid,int piles[],int h){
        int hours=0;
        for(int i:piles){
            hours+=(long)(i+mid-1)/mid;
        }
        return hours<=h;
    }
}
