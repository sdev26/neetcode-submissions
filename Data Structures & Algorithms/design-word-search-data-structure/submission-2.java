class WordDictionary {
    class TrieNode{
        TrieNode children[]=new TrieNode[26];
        boolean isEnd=false;
    }
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            int indx=c-'a';
            if(curr.children[indx]==null)
                curr.children[indx]=new TrieNode();
            curr=curr.children[indx];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        return dfs(word,root,0);
    }
    public boolean dfs(String word,TrieNode root,int pos){
        if(root==null)
            return false;
        if(pos==word.length())
            return root.isEnd;
        Character ch=word.charAt(pos);
        if(ch=='.'){
            for(TrieNode child:root.children){
                if(child!=null&&dfs(word,child,pos+1))
                    return true;
            }
            return false;
        }
    int indx=ch-'a';
    return dfs(word,root.children[indx],pos+1);
    }
}
