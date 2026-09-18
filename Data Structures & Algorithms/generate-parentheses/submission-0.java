class Solution {
  List<String>ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, new StringBuilder(), 0, 0);
        return ans;
    }

    public void dfs(int n,StringBuilder curr,int open,int close) {
        if(curr.length()==2*n){
            ans.add(curr.toString());
            return;
        }
        if(open<n){
            curr.append('(');
            dfs(n,curr,open+1,close);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close<open){
            curr.append(')');
            dfs(n,curr,open,close+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}

