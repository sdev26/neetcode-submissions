class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,maxPile=-1;
        for(int t:piles){
            maxPile=Math.max(maxPile,t);
        }
        int right=maxPile;
        int ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(canFinish(mid,piles,h)){
                ans=mid;
                right=mid-1;
            }
            else
                left=mid+1;
        }
        return ans;
    }
    public  boolean canFinish(int mid,int []piles,int h){
        int hours=0;
        for(int i:piles){
            hours+=(long)(i+mid-1)/mid;
        }
        return hours<=h;
    }
}
