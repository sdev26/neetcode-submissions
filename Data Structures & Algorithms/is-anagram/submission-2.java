class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer>hs=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hs.containsKey(s.charAt(i)))
                hs.put(s.charAt(i),hs.get(s.charAt(i))+1);
            else
                hs.put(s.charAt(i),1);
        }
        HashMap<Character,Integer>hs2=new HashMap<>();
         for(int i=0;i<t.length();i++){
            if(hs2.containsKey(t.charAt(i)))
                hs2.put(t.charAt(i),hs2.get(t.charAt(i))+1);
            else
                hs2.put(t.charAt(i),1);
        }
        if(hs.size()!=hs2.size())
            return false;
        for(Character c:hs.keySet()){
            if(!hs.get(c).equals(hs2.get(c)))
                return false;
        }
        return true;
    }
}
