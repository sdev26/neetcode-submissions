class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>>al=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            if(i>0&&nums[i]==nums[i-1])continue;
                int left=i+1;
                int right=nums.length-1;
                while(left<right){
                int sum=a+nums[left]+nums[right];
                if(sum==0){
                    List<Integer>t=new ArrayList<>();
                    t.add(a);t.add(nums[left]);t.add(nums[right]);
                    al.add(t);
                    while(left<right && nums[left]==nums[left+1]){left++;}
                    while(left<right&& nums[right]==nums[right-1]){right--;}
                    left++;right--;
                }
                else if (sum<0){
                    left++;
                }
                else{
                    right--;
                }
                }
            
        }
        return al;
    }
}
