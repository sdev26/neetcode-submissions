class PrefixTree {
    class TrieNode{
        TrieNode[]children=new TrieNode[26];
        boolean isEnd=false;
    }
    TrieNode root;

    public PrefixTree() {
         root=new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr=root;
        for(Character c:word.toCharArray()){
            int indx=c-'a';
            if(curr.children[indx]==null)
                curr.children[indx]=new TrieNode();
            curr=curr.children[indx];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode curr=findNode(word);
        return curr!=null&&curr.isEnd;

    }

    public boolean startsWith(String prefix) {
        TrieNode curr=findNode(prefix);
        return curr!=null;
    }
    public TrieNode findNode(String word){
        TrieNode curr=root;
        for(Character c:word.toCharArray()){
            int index=c-'a';
            if(curr.children[index]==null)
                return null;
            curr=curr.children[index];
        }
        return curr;
    }
}
