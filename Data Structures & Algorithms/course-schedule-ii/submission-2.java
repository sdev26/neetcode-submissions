class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:prerequisites)
        {
            int u=e[0];
            int v=e[1];
            adj.get(v).add(u);
        }
        int indegree[]=new int[numCourses];
        for(int i=0;i<indegree.length;i++){
            for(int x:adj.get(i))
                indegree[x]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.poll();
            ans.add(curr);
            for(int v:adj.get(curr)){
                if(--indegree[v]==0)
                    q.add(v);
            }
        }
        if(ans.size()!=numCourses)
            return new int[]{};
        int res[]=new int[ans.size()];
        for(int i=0;i<res.length;i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}
