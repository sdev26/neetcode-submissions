class Solution {
    public int countComponents(int n, int[][] edges) {
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
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                count++;
                dfs(adj,visited,i);
            }
        }
        return count;
    }
    public void dfs(ArrayList<ArrayList<Integer>>adj,boolean[]visited,int src){
        visited[src]=true;
        for(int n:adj.get(src)){
            if(visited[n]==false)
                dfs(adj,visited,n);
        }
    }
}
