class Solution {
       List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
     
         dfs(new ArrayList<>(),nums,0);
         return ans;
    }
    public void dfs(List<Integer>curr,int[]nums,int index){
        if(index==nums.length){
            ans.add(new ArrayList<>(curr));return;
        }
        curr.add(nums[index]);
        dfs(curr,nums,index+1);
        curr.remove(curr.size() - 1);
        dfs(curr,nums,index+1);
    }
}
