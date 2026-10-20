class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[]f1=new int[26];
        int[]f2=new int[26];
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            f1[curr-'a']++;
        }
        for(int i=0;i<t.length();i++){
            char curr=t.charAt(i);
            f2[curr-'a']++;
        }
        for(int i=0;i<f1.length;i++){
            if(f1[i]!=f2[i])
                return false;
        }
        return true;
    }
}
