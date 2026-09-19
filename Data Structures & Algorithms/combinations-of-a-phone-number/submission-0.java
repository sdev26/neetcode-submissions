class Solution {
    List<String>ans=new ArrayList<>();
    String map[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return ans;
        dfs(digits,0,new StringBuilder());
        return ans;
    }
    public void dfs(String digits,int index,StringBuilder curr){
        if(index==digits.length()){
            ans.add(curr.toString());return;
        }
        int digit=Integer.valueOf(digits.charAt(index)-'0');
        String mapping=map[digit];
        for(char c:mapping.toCharArray()){
            curr.append(c);
            dfs(digits,index+1,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
