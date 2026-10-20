class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>hm=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            int freq[]=new int[26];
            for(char c:s.toCharArray()){
                freq[c-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for(int t=0;t<26;t++){
                if(freq[t]!=0){
                    sb.append((char)'a'+t);
                    sb.append('#');
                    sb.append(freq[t]);
                    sb.append('#');
                }
            }
            String key=sb.toString();
            if(!hm.containsKey(key))
                hm.put(key,new ArrayList<>());
            hm.get(key).add(s);
        }
        return new ArrayList<>(hm.values());
    }
}
