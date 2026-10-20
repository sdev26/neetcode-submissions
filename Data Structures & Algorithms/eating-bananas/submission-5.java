class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxHeight=0;
        for(int i:piles){
            maxHeight=Math.max(maxHeight,i);
        }
        int left=1,right=maxHeight,ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(isPossible(piles,mid,h)){
                ans=mid;
                right=mid-1;
            }
            else
                left=mid+1;
        }
        return ans;
    }
    public boolean isPossible(int []piles,int mid,int h){
        long hours=0;
        for(int i:piles){
            hours+=(long)(i+mid-1)/mid;
        }
        return hours<=h;
    }
}
