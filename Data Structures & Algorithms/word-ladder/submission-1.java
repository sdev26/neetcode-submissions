class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>hs=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            hs.add(wordList.get(i));
        }
        if(!hs.contains(endWord))
            return 0;
        Queue<String>q=new LinkedList<>();
        q.add(beginWord);
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String curr=q.poll();
                if(curr.equals(endWord))
                    return level;
                char[]c=curr.toCharArray();
                for(int j=0;j<c.length;j++){
                    char orignal=c[j];
                    for(char t='a';t<='z';t++){
                        c[j]=t;
                       String temp = new String(c);
                        if(hs.contains(temp)){
                            q.add(temp);
                            hs.remove(temp);
                        }
                    }
                    c[j]=orignal;
                }
            }
            level++;
        }
        return 0;
    }
}
