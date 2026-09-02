class Solution {
    int dp[][];
    int[][] dir = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
 
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        dp=new int[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,dfs(matrix,i,j));
            }
        }
        return ans;
    }
    public int dfs(int matrix[][],int row,int col){
        if(dp[row][col]!=0)
            return dp[row][col];
        dp[row][col]=1;
        int m=matrix.length;
        int n=matrix[0].length;
        for(int d[]:dir){
            int nr=row+d[0];
            int nc=col+d[1];
            if(nr>=0&&nc>=0&&nr<m&&nc<n&&matrix[nr][nc]>matrix[row][col]){
                dp[row][col]=Math.max(dp[row][col],1+dfs(matrix,nr,nc));
            }
        }
        return dp[row][col];
    }
}
