class Solution {
    HashMap<String,PriorityQueue<String>>hm;
    List<String>ans;
    public List<String> findItinerary(List<List<String>> tickets) {
        hm=new HashMap<>();
        ans=new ArrayList<>();
        for(List<String>ticket:tickets){
            String src=ticket.get(0);
            String dest=ticket.get(1);
            hm.putIfAbsent(src,new PriorityQueue<>());
            hm.get(src).offer(dest);
        }
        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }
    public void dfs(String src){
        PriorityQueue<String>pq=hm.get(src);
        while(pq!=null&&!pq.isEmpty()){
            String t=pq.poll();
            dfs(t);
        }
        ans.add(src);
    }
}
