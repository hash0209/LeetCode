class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        int freshCount = 0;

        boolean isFresh = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int mins = 0;

         int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!q.isEmpty()) {
            int size = q.size();
            for (int u = 0; u < size; u++) {
                Pair cell = q.poll();
                int i = cell.i;
                int j = cell.j;

                for(int d =0; d < dir.length ; d++){
                    int ni = i + dir[d][0];
                    int nj = j + dir[d][1];

                    if(ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] !=0 && !visited[ni][nj] ){
                          q.add(new Pair(ni,nj));
                          visited[ni][nj] = true;
                          freshCount--;
                    }
                }

                

            }
            if (!q.isEmpty()) {

                mins++;
            }
        }

       if(freshCount!=0){
        return -1;
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