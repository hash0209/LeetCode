class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    board[i][j] = '$';
                    boolean ans = find(i, j, board, word, 1);
                    board[i][j] = word.charAt(0);
                    if (ans) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public boolean find(int m, int n, char[][] board, String word, int index) {

      

        if (index == word.length()) {
            return true;
        }

        //  if(m >= board.length || n >= board[0].length){
        //    return false;
        //   }
        //  if(board[m][n] == word.charAt(index)){
        //      board[m][n]='$';

        //       ans = find(m , n , board , word, index+1);
        //         board[m][n] = word.charAt(index);
        //        return ans;
        //  }

        char c = word.charAt(index);
        boolean right = match(board, c, m, n + 1);
        if (right) {
            right = find(m, n+1, board, word, index + 1);
            board[m][n+1] = c;
            if(right){
                return true;
            }
        }

        boolean left = match(board, c, m, n - 1);
        if (left) {
            left = find(m , n-1, board, word, index + 1);
             board[m][n-1] = c;
            if(left){
                return true;
            }
        }

        boolean up = match(board, c, m - 1, n);
        if (up) {
            up = find(m -1, n, board, word, index + 1);
             board[m-1][n] = c;
           if(up){
                return true;
            }
        }

        boolean down = match(board, c, m + 1, n);
        if (down) {
            down = find(m + 1, n, board, word, index + 1);
            board[m+1][n] = c;
           if(down){
                return true;
            }
        }
        return false;
      
    }

    public boolean match(char[][] board, char c, int m, int n) {
        if (m >= board.length || n >= board[0].length || m < 0 || n <0) {
            return false;
        }
        if (board[m][n] == c){
            board[m][n] = '$';

            //  ans = find(m , n , board , word, index+1);
            //   board[m][n] = word.charAt(index);
            return true;
        }

        return false;
    }

}