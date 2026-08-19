class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:prerequisites){
            int u=e[0];
            int v=e[1];
            adj.get(v).add(u);
        }
        int indegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
                for(int x:adj.get(i)){
                    indegree[x]++;
                }
        }
       ArrayList<Integer>res=new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            res.add(curr);
            for(int v:adj.get(curr)){
                if(--indegree[v]==0)
                    q.add(v);
            }
        }
    if(res.size()!=numCourses)
        return new int[]{};
    
    int ans[]=new int[res.size()];
    for(int i=0;i<res.size();i++){
        ans[i]=res.get(i);
    }
    return ans;
    }
}
