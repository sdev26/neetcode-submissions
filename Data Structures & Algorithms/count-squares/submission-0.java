class CountSquares {
    HashMap<String,Integer>hm;
    public CountSquares() {
        hm=new HashMap<>();
    }
    
    public void add(int[] point) {
        String key=point[0]+","+point[1];
        hm.put(key,hm.getOrDefault(key,0)+1);
    }
    
    public int count(int[] point) {
        int x=point[0],y=point[1];
        int ans=0;
        for(String key:hm.keySet()){
            String[]parts=key.split(",");
            int x2=Integer.parseInt(parts[0]);
            int y2=Integer.parseInt(parts[1]);
            if(x==x2||y==y2)
                continue;
            if(Math.abs(x2-x)!=Math.abs(y2-y))
                continue;
            String p1=x+","+y2;
            String p2=x2+","+y;

            ans+=hm.get(key)*hm.getOrDefault(p1,0)*hm.getOrDefault(p2,0);
        }
        return ans;
    }
}
