class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    fresh++;
                if(grid[i][j]==2)
                    q.add(new int[]{i,j});
            }
        }
        int dir[][]={
            {0,1},{0,-1},{1,0},{-1,0}
        };
        int min=0;
        while(!q.isEmpty()){
            int size=q.size();
             boolean isInfected=false;
            for(int i=0;i<size;i++){
            int curr[]=q.poll();
           
            for(int d[]:dir){
                int nr=curr[0]+d[0];
                int nc=curr[1]+d[1];
                if(nr>=0&&nc>=0&&nr<m&&nc<n&&grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    isInfected=true;
                    fresh--;
                    q.add(new int[]{nr,nc});
                }
               
            }
            }
             if(isInfected)min++;
        }
        if(fresh!=0)return -1;
        return min;
    }
}
