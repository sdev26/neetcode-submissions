class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m=nums1.length;
        int n=nums2.length;
        int left=0,right=m;
        while(left<=right){
            int cutA=left+(right-left)/2;
            int cutB=(m+n+1)/2-cutA;
            
            int leftA=(cutA==0)?Integer.MIN_VALUE:nums1[cutA-1];
            int rightA=(cutA==m)?Integer.MAX_VALUE:nums1[cutA];

            int leftB=(cutB==0)?Integer.MIN_VALUE:nums2[cutB-1];
            int rightB=(cutB==n)?Integer.MAX_VALUE:nums2[cutB];

            if(leftA<=rightB&&leftB<=rightA){
                if((m+n)%2==1){
                    return Math.max(leftA,leftB);
                }
                else{
                    return (Math.max(leftA,leftB)+Math.min(rightA,rightB))/2.0;
                }
            }
            else if (leftA>rightB){
                right=cutA-1;
            }
            else{
                left=cutA+1;
            }
        }
        return 0;
    }
}
