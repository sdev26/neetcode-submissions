class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones){
            pq.add(i);
        }
        while(pq.size()>1){
            int n1=pq.poll();
            int n2=pq.poll();
            int diff=Math.abs(n1-n2);
            if(diff>0)pq.add(diff);
        }
        return pq.peek()==null?0:pq.peek();
    }
}
