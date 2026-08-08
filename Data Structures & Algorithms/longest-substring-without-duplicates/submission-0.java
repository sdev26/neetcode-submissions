class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,max=0;
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int right=0;right<s.length();right++){
            if(hm.containsKey(s.charAt(right))){
                left=Math.max(left,hm.get(s.charAt(right))+1);
            }
            max=Math.max(max,right-left+1);
            hm.put(s.charAt(right),right);
        }
        return max;
    }
}
