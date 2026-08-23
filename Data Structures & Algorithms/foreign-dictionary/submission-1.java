class Solution {
    public String foreignDictionary(String[] words) {
      HashMap<Character,List<Character>>adj=new HashMap<>();
      HashMap<Character,Integer>indegree=new HashMap<>();
      for(String word:words){
        char temp[]=word.toCharArray();
        for(int i=0;i<temp.length;i++){
            adj.putIfAbsent(temp[i],new ArrayList<>());
            indegree.putIfAbsent(temp[i],0);
        }
      }
      for(int i=0;i<words.length-1;i++){
        String word1=words[i];
        String word2=words[i+1];
        int n=Math.min(word1.length(),word2.length());
        boolean found=false;
        for(int j=0;j<n;j++){
            if(word1.charAt(j)!=word2.charAt(j)){
                char from=word1.charAt(j);
                char to=word2.charAt(j);
                adj.get(from).add(to);
                indegree.put(to,indegree.get(to)+1);
                found=true;
                break;
            }
        }
        if(!found&&word1.length()>word2.length()){
                return "";
        }
      }
      Queue<Character>q=new LinkedList<>();
        for(char c:indegree.keySet()){
            if(indegree.get(c)==0)
                q.add(c);
        }
        StringBuilder ans=new StringBuilder();
        while(!q.isEmpty()){
            char curr=q.poll();
            ans.append(curr);
            for(char next:adj.get(curr)){
                indegree.put(next, indegree.get(next)-1);
                if(indegree.get(next)==0)
                    q.add(next);
            }
        }
       if(ans.length()!=indegree.size())
         return "";
        return ans.toString();
    }
}
