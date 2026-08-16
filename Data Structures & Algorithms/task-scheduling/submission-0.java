class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            if(hm.containsKey(tasks[i]))
                hm.put(tasks[i],hm.get(tasks[i])+1);
            else
                hm.put(tasks[i],1);
        }
        PriorityQueue<Character>pq=new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
        for(Character c:hm.keySet()){
            pq.add(c);
        }
        Queue<int[]>q=new LinkedList<>();
        int time=0;
        while(!pq.isEmpty()||!q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                char curr=pq.poll();
                hm.put(curr,hm.get(curr)-1);
                if(hm.get(curr)>0){
                q.add(new int[]{curr,time+n});
                }
            }
            if(!q.isEmpty()&&q.peek()[1]==time){
                pq.add((char)q.poll()[0]);
            }
        }
        return time;
    }
}
