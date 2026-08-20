class Solution {
    class Pair{
        int v,w;
        Pair(int v,int w){
            this.v=v;
            this.w=w;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:times){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            adj.get(u).add(new Pair(v,w));
        }
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<Pair>q=new PriorityQueue<>((a,b)->a.w-b.w);
        q.add(new Pair(k,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int v=p.v;
            int w=p.w;
            if(dist[v]<w)
                continue; 
            for(Pair t:adj.get(v)){
                if(w+t.w<dist[t.v]){
                    dist[t.v]=w+t.w;
                    q.add(new Pair(t.v,dist[t.v]));
                }
            }
        }
                int max=0;
        for(int i=1;i<=n;i++){
            max=Math.max(max,dist[i]);
        }
        return max==Integer.MAX_VALUE?-1:max;
    
    }
}
