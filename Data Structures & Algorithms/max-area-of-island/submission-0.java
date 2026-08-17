class Solution {
    int max=0,area=0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(grid,i,j));
                }
            }
        }
        return max;
    }
    public int dfs(int[][]grid,int i,int j){
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]==0)      
                return 0;
         
            grid[i][j]=0;
            return 1+dfs(grid,i+1,j)+dfs(grid,i-1,j)+dfs(grid,i,j-1)+dfs(grid,i,j+1);
        
    }
}
