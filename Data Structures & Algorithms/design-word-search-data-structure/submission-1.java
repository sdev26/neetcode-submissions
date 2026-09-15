class WordDictionary {
    class TrieNode{
        TrieNode[]children=new TrieNode[26];
        boolean isEnd;
    }
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            int indx=c-'a';
            if(curr.children[indx]==null){
                curr.children[indx]=new TrieNode();
            }
            curr=curr.children[indx];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        return dfs(root,word,0);
    }
    public boolean dfs(TrieNode root,String word,int pos){
        if(root==null)
            return false;
        if(pos==word.length()){
            return root.isEnd;
        }
        char c=word.charAt(pos);
        if(c=='.'){
            for(TrieNode child:root.children){
                if(child!=null&&dfs(child,word,pos+1))
                    return true;
            }
            return false;
        }
        int indx=c-'a';
        return dfs(root.children[indx],word,pos+1);
    }
}
