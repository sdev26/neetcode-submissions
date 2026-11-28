class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>hm=new HashMap<>();
        int left=0;
        int max=0;
        for(int right=0;right<s.length();right++){
            if(!hm.containsKey(s.charAt(right))){
                hm.put(s.charAt(right),right);
            }
            else{
               
                left=Math.max((hm.get(s.charAt(right)))+1,left);
                hm.put(s.charAt(right),right);
            }
             max=Math.max(max,right-left+1);
        }
        return max;
    }
}
