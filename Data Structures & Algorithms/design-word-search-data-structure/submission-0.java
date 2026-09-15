class WordDictionary {

 class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()) {
            int idx = c - 'a';

            if(curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int pos) {

        if(node == null)
            return false;

        if(pos == word.length())
            return node.isEnd;

        char c = word.charAt(pos);

        if(c == '.') {

            for(TrieNode child : node.children) {

                if(child != null && dfs(child, word, pos + 1)) {
                    return true;
                }

            }

            return false;
        }

        int idx = c - 'a';

        return dfs(node.children[idx], word, pos + 1);
    }
}
