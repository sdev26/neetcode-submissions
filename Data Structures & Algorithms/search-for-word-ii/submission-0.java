class Solution {
class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    List<String> ans = new ArrayList<>();
    int m, n;

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = buildTrie(words);

        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }

        return ans;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node) {

        if (row < 0 || col < 0 || row >= m || col >= n)
            return;

        char ch = board[row][col];

        if (ch == '#')
            return;

        node = node.children[ch - 'a'];

        if (node == null)
            return;

        if (node.word != null) {
            ans.add(node.word);

            // avoid duplicates
            node.word = null;
        }

        board[row][col] = '#';

        dfs(board, row + 1, col, node);
        dfs(board, row - 1, col, node);
        dfs(board, row, col + 1, node);
        dfs(board, row, col - 1, node);

        board[row][col] = ch;
    }

    private TrieNode buildTrie(String[] words) {

        TrieNode root = new TrieNode();

        for (String word : words) {

            TrieNode curr = root;

            for (char ch : word.toCharArray()) {

                int idx = ch - 'a';

                if (curr.children[idx] == null)
                    curr.children[idx] = new TrieNode();

                curr = curr.children[idx];
            }

            curr.word = word;
        }

        return root;
    }
}
