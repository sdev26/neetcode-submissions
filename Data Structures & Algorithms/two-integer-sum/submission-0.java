class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(hm.containsKey(nums[i]))
                return new int[]{hm.get(nums[i]),i};
            else
                hm.put(complement,i);
        }
        return new int[]{};
    }
}
