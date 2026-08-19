class Solution {
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean []visited=new boolean[n];
         if (!dfs(adj, 0, -1, visited)) return false;
         for(boolean v:visited)if(!v)return false;
         return true;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>>adj,int src,int parent,boolean[]visited){
        visited[src]=true;
        for(int v:adj.get(src)){
           if(!visited[v]){
                if(!dfs(adj,v,src,visited))return false;
           }
           else if(v!=parent){
            return false;
           } 
        }
        return true;
    }
}
