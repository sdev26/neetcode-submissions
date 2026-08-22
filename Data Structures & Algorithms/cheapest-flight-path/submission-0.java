class Solution {
    class Pair{
        int city,cost,stops;
        Pair(int city,int cost,int stops){
            this.city=city;
            this.cost=cost;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:flights){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            adj.get(u).add(new Pair(v,w,0));
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(src,0,0));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            if(curr.stops>k)
                continue;
            for(Pair next:adj.get(curr.city)){
                int newCost=curr.cost+next.cost;
                if(newCost<dist[next.city]){
                    dist[next.city]=newCost;
                    q.add(new Pair(next.city,newCost,curr.stops+1));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
