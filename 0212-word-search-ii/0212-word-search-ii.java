class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            char[] ch = word.toCharArray();

            for (int i = 0; i < ch.length; i++) {
                int idx = ch[i] - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;

        }

        List<String> ans = new ArrayList<String>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                find(i, j, root, board, ans);
            }
        }
        return ans;
    }

    public void find(int row, int col, TrieNode node, char[][] board, List<String> result) {
        if (row < 0 || col < 0 || row == board.length || col == board[0].length) {
            return;
        }
       

        if (board[row][col] == '.' || node.children[board[row][col] - 'a'] == null) {
            return;
        }

        node = node.children[board[row][col] - 'a'];

         if (node.word != null) {
            result.add(node.word);
            node.word = null;
           
        }

        char ch = board[row][col];

        board[row][col] = '.';
        

        find(row + 1, col, node, board,result);
        find(row - 1, col, node, board,result);
        find(row, col + 1, node, board,result);
        find(row, col - 1, node, board,result);
        board[row][col] = ch;
    }
}

class TrieNode {
    TrieNode children[];
    String word;

    public TrieNode() {
        children = new TrieNode[26];
    }
}