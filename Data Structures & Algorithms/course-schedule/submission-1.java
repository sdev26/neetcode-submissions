class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        int count=0;
    
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:prerequisites){
            int u=e[0];
            int v=e[1];
            adj.get(v).add(u);
        }
        int indegree[]=new int[numCourses];
        for(int i=0;i<indegree.length;i++){
            for(int u:adj.get(i))
                indegree[u]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int u=q.poll();
            count++;
            for(int v:adj.get(u)){
                if(--indegree[v]==0)
                    q.add(v);
            }
        }
        return (count==numCourses);
    }
}
