class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i:nums){
            if(hm.containsKey(i))
                hm.put(i,hm.get(i)+1);
            else
                hm.put(i,1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->hm.get(a)-hm.get(b));
        for(int i:hm.keySet()){
            pq.add(i);
            if(pq.size()>k)
                pq.poll();
        }
        int res[]=new int[k];
        for(int i=0;i<k;i++){
            res[i]=pq.poll();
        }
        return res;
    }
}
