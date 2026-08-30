class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>hm=new HashMap<>();
        int left=0,max=0;
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                left=Math.max(left,hm.get(s.charAt(i))+1);
            }
            max=Math.max(max,i-left+1);
            hm.put(s.charAt(i),i);
        }
        return max;
    }
}
