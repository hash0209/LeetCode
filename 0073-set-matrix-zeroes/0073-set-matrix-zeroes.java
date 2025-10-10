class Solution {
    public void setZeroes(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;

        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    setZeroes(i, j, matrix, visited);
                }
            }
        }
    }

    public void setZeroes(int r, int c, int[][] matrix, boolean[][] visited) {

        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[r][col] != 0) {
                matrix[r][col] = 0;
                visited[r][col] = true;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][c] != 0) {
                matrix[row][c] = 0;
                visited[row][c] = true;
            }
        }
    }
}
