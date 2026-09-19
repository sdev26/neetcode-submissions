class Solution {
    List<List<String>>ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][]board=new char[n][n];
          for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
      
        HashSet<Integer>col=new HashSet<>();
        HashSet<Integer>diag1=new HashSet<>();
        HashSet<Integer>diag2=new HashSet<>();
        dfs(board,0,col,diag1,diag2);
        return ans;
    }
    public void dfs(char[][]board,int row,HashSet<Integer>col,HashSet<Integer>diag1,HashSet<Integer>diag2){
           int n=board.length;
            List<String>temp=new ArrayList<>();
            if(row==n){
                for(char[]r:board){
                    temp.add(new String(r));
                }
                ans.add(temp);
                return;
            }
            for(int i=0;i<n;i++){
                if(col.contains(i)||diag1.contains(row-i)||diag2.contains(row+i))
                    continue;
                board[row][i]='Q';
                col.add(i);
                diag1.add(row-i);
                diag2.add(row+i);
                dfs(board,row+1,col,diag1,diag2);
                board[row][i]='.';
                col.remove(i);
                diag1.remove(row-i);
                diag2.remove(row+i);
            }
    }
}
