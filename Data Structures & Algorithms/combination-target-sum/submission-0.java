class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums,target,0,new ArrayList<>());
        return ans;
    }
    public void dfs(int []nums,int target,int index,List<Integer>curr){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(index==nums.length||target<0){
            return;
        }
        curr.add(nums[index]);
        dfs(nums,target-nums[index],index,curr);
        curr.remove(curr.size()-1);
        dfs(nums,target,index+1,curr);
            
    }   
}
