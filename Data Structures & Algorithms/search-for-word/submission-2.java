class Solution {
    int m,n;
    public boolean exist(char[][] board, String word) {
        m=board.length;n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,word,0,i,j))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][]board,String word,int index,int i,int j){
        if(i<0||j<0||i>=m||j>=n)
            return false;
        if(board[i][j]!=word.charAt(index))
            return false;
        if(index==word.length()-1)
            return true;
        char temp=board[i][j];
        board[i][j]='#';
        boolean found=dfs(board,word,index+1,i+1,j)||
                    dfs(board,word,index+1,i-1,j)||
                    dfs(board,word,index+1,i,j+1)||
                    dfs(board,word,index+1,i,j-1);
        board[i][j]=temp;
        return found;
    }
}
