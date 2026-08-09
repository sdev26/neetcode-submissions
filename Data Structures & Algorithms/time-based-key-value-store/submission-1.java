class TimeMap {
    class Pair{
        String  value;int timestamp;
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
        
        if(hm.containsKey(key))
            hm.get(key).add(new Pair(value,timestamp));
        else{
            List<Pair>t=new ArrayList<>();
            t.add(new Pair(value,timestamp));
        hm.put(key,t);
        }
           
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key))
        return "";
        List<Pair> p=hm.get(key);
        int left=0,right=p.size() - 1;
        String ans = "";
                while(left <= right){
            int mid = left + (right-left)/2;

            if(p.get(mid).timestamp <= timestamp){
                ans = p.get(mid).value;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return ans;
    }
}
