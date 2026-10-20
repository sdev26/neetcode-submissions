class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer>hs=new HashSet<>();
       for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
       }
       int max=Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++){
            if(!hs.contains(nums[i]-1)){
                int start=nums[i];int count=1;
                while(hs.contains(start+1)){
                    count++;start++;
                }
                max=Math.max(count,max);
            }
       }
       return max==Integer.MIN_VALUE?0:max;
    }
}
