class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        boolean isFresh = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
                if (grid[i][j] == 1) {
                    isFresh = true;
                }
            }
        }

        int mins = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int u = 0; u < size; u++) {
                Pair cell = q.poll();
                int i = cell.i;
                int j = cell.j;

                if (i - 1 >= 0 && grid[i - 1][j] != 0 && !visited[i - 1][j]) {

                    q.add(new Pair(i - 1, j));
                    visited[i - 1][j] = true;

                }

                if (i + 1 < m && grid[i + 1][j] != 0 && !visited[i + 1][j]) {
                    q.add(new Pair(i + 1, j));
                    visited[i + 1][j] = true;
                }

                if (j - 1 >= 0 && grid[i][j - 1] != 0 && !visited[i][j - 1]) {
                    q.add(new Pair(i, j - 1));
                    visited[i][j - 1] = true;
                }

                if (j + 1 < n && grid[i][j + 1] != 0 && !visited[i][j + 1]) {

                    q.add(new Pair(i, j + 1));
                    visited[i][j + 1] = true;
                }

            }
            if (!q.isEmpty()) {

                mins++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }
        return mins;

    }
}

class Pair {
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

}