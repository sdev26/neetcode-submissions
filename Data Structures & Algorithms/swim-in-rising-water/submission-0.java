class Solution {
    class Node{
        int time,r,c;
        Node(int time,int r,int c){
            this.time=time;
            this.r=r;
            this.c=c;
        }
    }
    public int swimInWater(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
       int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
       boolean visited[][]=new boolean[m][n];
       PriorityQueue<Node>pq=new PriorityQueue<>((a,b)->(a.time-b.time));
       pq.add(new Node(grid[0][0],0,0));
       while(!pq.isEmpty()){
        Node curr=pq.poll();
        if(visited[curr.r][curr.c])
            continue;
        visited[curr.r][curr.c] = true;
        if(curr.r==n-1&&curr.c==n-1)
            return curr.time;
        
        for(int d[]:dirs){
            int nr=curr.r+d[0];
            int nc=curr.c+d[1];
            if(nr>=0&&nc>=0&&nr<m&&nc<n&&visited[nr][nc]!=true){
                int newTime=Math.max(curr.time,grid[nr][nc]);
                pq.add(new Node(newTime,nr,nc));
            }
        }
       }
       return -1;
    }
}
