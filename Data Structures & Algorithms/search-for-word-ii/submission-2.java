class Solution {
    class TrieNode{
        TrieNode[]children=new TrieNode[26];
        String word;
    }
    List<String>ans=new ArrayList<>();
    int m,n;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=buildTree(words);
        m=board.length;n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(board,root,i,j);
            }
        }
        return ans;        
    }
    public void dfs(char[][]board,TrieNode root,int i,int j){
        if(i<0||j<0||i>=m||j>=n)
            return;
        char ch=board[i][j];
        if(ch=='#')
            return;
        root=root.children[ch-'a'];
        if(root==null)
            return;
        if(root.word!=null){
            ans.add(root.word);
            root.word=null;
        }
        board[i][j]='#';
        dfs(board,root,i+1,j);
        dfs(board,root,i-1,j);
        dfs(board,root,i,j+1);
        dfs(board,root,i,j-1);
        board[i][j]=ch;
    
    }
    public TrieNode buildTree(String[]words){
        TrieNode root=new TrieNode();
        for(String word:words){
            TrieNode curr=root;
            for(char c:word.toCharArray()){
                int indx=c-'a';
                if(curr.children[indx]==null)
                    curr.children[indx]=new TrieNode();
                curr=curr.children[indx];
            }
            curr.word=word;
        }
        return root;
    }
}
