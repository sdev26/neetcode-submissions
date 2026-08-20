class Solution {
    class DSU{
        int parent[],size[];
        DSU(int n){
            parent=new int[n];
            size=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
            int find(int x){
                if(parent[x]==x)
                    return x;
                parent[x]=find(parent[x]);
                return parent[x];
            }
            boolean union(int u,int v){
                int fu=find(u);
                int fv=find(v);
                if(fv==fu)
                    return false;
                else if(size[fu]<size[fv]){
                    parent[fu]=fv;
                    size[fv]+=size[fu];
                }
                else{
                    parent[fv]=fu;
                    size[fu]+=size[fv];
                }
                return true;
            }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu=new DSU(edges.length+1);
        for(int e[]:edges){
            if(!dsu.union(e[0],e[1])){
                return e;
            }
        }
        return new int[]{};
    }
}
