class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashSet<Integer>hs=new HashSet<>();
        for(int i:nums)
            hs.add(i);
        int arr[]=new int[n];
          int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(!hs.contains(nums[i]-1)){
                int count=1,start=nums[i];
              while(hs.contains(start+1)){
                  
                        count++;start++;
                    
                }
                max=Math.max(max,count);
            }
        }

        return max==Integer.MIN_VALUE?0:max;
    }
}
