class Solution {
    int dir[][]={
        {1,0},{-1,0},{0,1},{0,-1}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        boolean [][]pacific=new boolean[m][n];
        boolean[][]atlantic=new boolean[m][n];

        for(int i=0;i<n;i++){
            dfs(heights,0,i,pacific);
        }
        for(int i=0;i<m;i++){
            dfs(heights,i,0,pacific);
        }
        for(int i=0;i<n;i++){
            dfs(heights,m-1,i,atlantic);
        }
        for(int i=0;i<m;i++){
            dfs(heights,i,n-1,atlantic);
        }
        List<List<Integer>>res=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(atlantic[i][j]&&pacific[i][j])
                    res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }
    public void dfs(int[][]heights,int r,int c,boolean[][]visited){
          if(visited[r][c])
            return;

        visited[r][c] = true;

        for(int[] d : dir) {

            int nr = r + d[0];
            int nc = c + d[1];

            if(nr < 0 || nc < 0 ||
               nr >= heights.length ||
               nc >= heights[0].length)
                continue;

            if(heights[nr][nc] < heights[r][c])
                continue;

            dfs(heights,nr,nc,visited);
        }
    }
}
