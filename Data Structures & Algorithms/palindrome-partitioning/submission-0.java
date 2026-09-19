class Solution {
    List<List<String>>ans=new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0,new ArrayList<>());
        return ans;
    }
    public void dfs(String s, int start,List<String>curr){
        if(start==s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<s.length();i++){
            String part=s.substring(start,i+1);
            if(isPallindrome(part)){
                curr.add(part);
                dfs(s,i+1,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean isPallindrome(String s){
        int start=0,end=s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;end--;
        }
        return true;
    }
}
