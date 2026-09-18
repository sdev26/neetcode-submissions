class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,new ArrayList<>(),0);
        return ans;
    }
    public void dfs(int[]nums,List<Integer>curr,int index){
      ans.add(new ArrayList(curr));
      for(int i=index;i<nums.length;i++){
        if(i>index&&nums[i]==nums[i-1])
            continue;
        curr.add(nums[i]);
        dfs(nums,curr,i+1);
        curr.remove(curr.size()-1);
      }
    }
}
