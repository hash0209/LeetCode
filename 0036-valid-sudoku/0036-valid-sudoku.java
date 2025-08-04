class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                int num = board[i][j] - '1';

                if (row[i][num] || col[j][num]) {
                    return false;
                }


                row[i][num] = col[j][num] = true;

            }

        }

        for (int rowStart = 0; rowStart < 3; rowStart++) {

            for (int colStart = 0; colStart < 3; colStart++) {
                boolean visited[] = new boolean[9];

                for (int r = rowStart * 3; r < rowStart * 3 + 3; r++) {

                    for (int c = colStart * 3; c < colStart * 3 + 3; c++) {

                        if (board[r][c] == '.') {
                            continue;
                        }

                        if (visited[board[r][c] -'1']) {
                            return false;
                        }
                        visited[board[r][c] -'1'] = true;

                    }
                }
            }
        }

        return true;

    }
}