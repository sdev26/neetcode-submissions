class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer>hm=new HashMap<>();
        int left=0,maxFreq=0,ans=0;
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
            maxFreq=Math.max(maxFreq,hm.get(s.charAt(i)));

            while((i-left+1)-maxFreq>k){
                hm.put(s.charAt(left),hm.get(s.charAt(left))-1);
                left++;
            }
            ans=Math.max(ans,i-left+1);
        }
        return ans;
        
    }
}
