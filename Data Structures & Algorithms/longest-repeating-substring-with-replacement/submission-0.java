class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer>hm=new HashMap<>();
        int left=0,ans=0,maxFreq=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            maxFreq=Math.max(maxFreq,hm.get(ch));

           while((right-left+1)-maxFreq>k){
            hm.put(s.charAt(left),hm.get(s.charAt(left))-1);
            left++;
           } 
           ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}
