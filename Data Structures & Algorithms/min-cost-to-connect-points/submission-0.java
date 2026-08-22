class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[]inMst=new boolean[n];
        pq.add(new int[]{0,0});
        int res=0;
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int w=curr[0];
            int u=curr[1];
            if(inMst[u])
                continue;
            inMst[u]=true;
            res+=w;
            for(int i=0;i<n;i++){
                int dist=Math.abs(points[u][0]-points[i][0])+
                         Math.abs(points[u][1]-points[i][1]);
                pq.add(new int[]{dist,i});
            }
        }
        return res;
    }
}
