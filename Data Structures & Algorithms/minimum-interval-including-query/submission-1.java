class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[]sortedQueries=queries.clone();
        Arrays.sort(sortedQueries);
        HashMap<Integer,Integer>hm=new HashMap<>();
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int i=0;
        for(int q:sortedQueries){
            while(i<intervals.length&&intervals[i][0]<=q){
                int left=intervals[i][0];
                int right=intervals[i][1];
                int len=right-left+1;
                pq.offer(new int[]{len,right});
                i++;
            }
            while(!pq.isEmpty()&&pq.peek()[1]<q){
                pq.poll();
            }
            hm.put(q,pq.isEmpty()?-1:pq.peek()[0]);
        }
        int ans[]=new int[queries.length];
        for(int j=0;j<ans.length;j++){
            ans[j]=hm.get(queries[j]);
        }
        return ans;
    }
}
