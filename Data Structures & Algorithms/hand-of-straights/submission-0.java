class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0)
            return false;
        TreeMap<Integer,Integer>hm=new TreeMap<>();
        for(int i:hand){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        while(!hm.isEmpty()){
            int curr=hm.firstKey();
            for(int i=curr;i<curr+groupSize;i++){
                if(!hm.containsKey(i))
                    return false;
            hm.put(i,hm.get(i)-1);
            if(hm.get(i) == 0)
            hm.remove(i);
            }
        }
        return true;
    }
}
