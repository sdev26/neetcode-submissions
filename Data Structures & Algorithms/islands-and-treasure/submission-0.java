class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]>q=new LinkedList<>();
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0)
                    q.add(new int[]{i,j});
            }
         }
         int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        while(!q.isEmpty()){
            int curr[]=q.poll();
            for(int d[]:dir){
                int nr=curr[0]+d[0];
                int nc=curr[1]+d[1];
                if(nr<0||nc<0||nr>=m||nc>=n)
                    continue;
                if(grid[nr][nc]!=Integer.MAX_VALUE)
                    continue;
                grid[nr][nc] = grid[curr[0]][curr[1]] + 1;
                q.add(new int[]{nr, nc});
            }

        }
    }
}
