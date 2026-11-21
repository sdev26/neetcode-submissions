class TimeMap {
    class Pair{
        String value;int timestamp;
        Pair(String value,int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        }
    }
    HashMap<String, List<Pair>> hm;
    public TimeMap() {
        hm=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key))
            hm.put(key,new ArrayList<>());
        List<Pair>t=hm.get(key);
        t.add(new Pair(value,timestamp));
        hm.put(key,t);
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key))
            return "";
        List<Pair>curr=hm.get(key);
        int left=0,right=curr.size();
        String ans="";
        while(left<right){
            int mid=left+(right-left)/2;
            if(curr.get(mid).timestamp<=timestamp){
                ans=curr.get(mid).value;
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return ans;
    }
}
